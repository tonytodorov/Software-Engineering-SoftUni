package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordImportDto;
import softuni.exam.models.dto.BorrowingRecordImportRootDto;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.enums.Genre;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private final static String BORROWING_RECORDS_PATH = "src/main/resources/files/xml/borrowing-records.xml";

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, LibraryMemberRepository libraryMemberRepository, BookRepository bookRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORDS_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        BorrowingRecordImportRootDto borrowingRecordImportRootDto = this.xmlParser.fromFile(BORROWING_RECORDS_PATH, BorrowingRecordImportRootDto.class);

        for (BorrowingRecordImportDto borrowingRecordImportDto : borrowingRecordImportRootDto.getBorrowingRecords()) {
            if (this.bookRepository.findByTitle(borrowingRecordImportDto.getBook().getTitle()).isEmpty() ||
                    this.libraryMemberRepository.findById(borrowingRecordImportDto.getMember().getId()).isEmpty() ||
                    !this.validationUtil.isValid(borrowingRecordImportDto)) {
                sb.append("Invalid borrowing record").append(System.lineSeparator());
                continue;
            }

            BorrowingRecord borrowingRecord = this.modelMapper.map(borrowingRecordImportDto, BorrowingRecord.class);
            borrowingRecord.setBook(this.bookRepository.findByTitle(borrowingRecord.getBook().getTitle()).get());
            borrowingRecord.setMember(this.libraryMemberRepository.findById(borrowingRecord.getMember().getId()).get());

            this.borrowingRecordRepository.saveAndFlush(borrowingRecord);

            sb.append(String.format("Successfully imported borrowing record %s - %s",
                    borrowingRecord.getBook().getTitle(),
                    borrowingRecord.getBorrowDate()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String exportBorrowingRecords() {
        StringBuilder sb = new StringBuilder();

        this.borrowingRecordRepository.findByBorrowDateBeforeOrderByBorrowDateDesc(LocalDate.of(2021, 9, 10))
                .stream()
                .filter(br -> br.getBook().getGenre() == Genre.SCIENCE_FICTION)
                .forEach(br -> {
                    sb.append(String.format("Book title: %s\n" +
                            "*Book author: %s\n" +
                            "**Date borrowed: %s\n" +
                            "***Borrowed by: %s %s",
                            br.getBook().getTitle(), br.getBook().getAuthor(),
                            br.getBorrowDate(), br.getMember().getFirstName(),
                            br.getMember().getLastName()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
