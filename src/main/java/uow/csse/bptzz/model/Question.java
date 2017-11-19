package uow.csse.bptzz.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-11-11
 * @since	1.1
 *
 */

@Entity(name = "Course")
@Table(name = "bptzz_question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long question_id;
    @Column(nullable = false, length = 65535, columnDefinition = "Text")
    private String content;
    @Column(nullable = false)
    private String optiona;
    @Column(nullable = false)
    private String optionb;
    @Column(nullable = false)
    private String optionc;
    @Column(nullable = false)
    private String optiond;
    @Column(nullable = false)
    private String answer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="question_course")
    @JsonManagedReference
    private Course course;

    public Question() {

    }

    public Question(String content, String optiona, String optionb, String optionc, String optiond, String answer) {
        this.content = content;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
        this.answer = answer;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
//  reserverd: need to test whether these two methods could work properly
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", content='" + content + '\'' +
                ", optiona='" + optiona + '\'' +
                ", optionb='" + optionb + '\'' +
                ", optionc='" + optionc + '\'' +
                ", optiond='" + optiond + '\'' +
                ", answer='" + answer + '\'' +
                ", course=" + course +
                '}';
    }
}
