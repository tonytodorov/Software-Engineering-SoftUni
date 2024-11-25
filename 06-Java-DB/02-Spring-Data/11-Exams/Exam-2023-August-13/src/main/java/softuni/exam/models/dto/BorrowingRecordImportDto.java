package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;
import softuni.exam.util.LocalDateAdapter;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordImportDto {

    @XmlElement(name = "borrow_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @NotNull
    private LocalDate borrowDate;

    @XmlElement(name = "return_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @NotNull
    private LocalDate returnDate;

    @XmlElement(name = "book")
    private BookTitleDto book;

    @XmlElement(name = "member")
    private LibraryMemberIdDto member;

    @XmlElement(name = "remarks")
    @Length(min = 3, max = 100)
    private String remarks;


    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BookTitleDto getBook() {
        return book;
    }

    public void setBook(BookTitleDto book) {
        this.book = book;
    }

    public LibraryMemberIdDto getMember() {
        return member;
    }

    public void setMember(LibraryMemberIdDto member) {
        this.member = member;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
