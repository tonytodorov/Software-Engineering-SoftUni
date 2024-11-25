package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberImportDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private final static String LIBRARY_MEMBERS_PATH = "src/main/resources/files/json/library-members.json";

    private final LibraryMemberRepository libraryMemberRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder sb = new StringBuilder();

        LibraryMemberImportDto[] libraryMemberImportDtos = this.gson.fromJson(readLibraryMembersFileContent(), LibraryMemberImportDto[].class);

        for (LibraryMemberImportDto libraryMemberImportDto : libraryMemberImportDtos) {
            if (this.libraryMemberRepository.findByPhoneNumber(libraryMemberImportDto.getPhoneNumber()).isPresent() ||
                    !this.validationUtil.isValid(libraryMemberImportDto)) {
                sb.append("Invalid library member").append(System.lineSeparator());
                continue;
            }

            LibraryMember libraryMember = this.modelMapper.map(libraryMemberImportDto, LibraryMember.class);
            this.libraryMemberRepository.saveAndFlush(libraryMember);

            sb.append(String.format("Successfully imported library member %s - %s",
                    libraryMember.getFirstName(),
                    libraryMember.getLastName()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
