package com.lambdaschool.devlibs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.devlibs.logging.Loggable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "answers")
@ApiModel(value = "Answer",
        description = "Answers for Devlibs")

public class Answers extends  Auditable implements Serializable {

        @ApiModelProperty(name = "answer id",
                value = "primary key for Role",
                required = true,
                example = "1")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long answerid;

        @ApiModelProperty(name = "answer",
                value = "The Name of the Answer. This name is hard coded throughout the application so change it with reservations!",
                required = true,
                example = "DATA")
        @Column(nullable = false)
        private String answer;

        @ApiModelProperty(name = "DevLibAnswers",
                value = "A List of the Users who are assigned this answer")
        @OneToMany(mappedBy = "answers",
                cascade = CascadeType.ALL)
        @JsonIgnoreProperties("answers")
        private List<DevLibAnswers> devLibAnswers = new ArrayList<>();

        public Answers(){}


        public Answers(String answer, List<DevLibAnswers> devLibAnswers) {
                this.answer = answer;
                this.devLibAnswers = devLibAnswers;
        }

        public Answers(String answer){
                this.answer = answer;
        }

        public long getAnswerid() {
                return answerid;
        }

        public void setAnswerid(long answerid) {
                this.answerid = answerid;
        }

        public String getAnswer() {
                return answer;
        }

        public void setAnswer(String answer) {
                this.answer = answer;
        }

        public List<DevLibAnswers> getDevLibAnswers() {
                return devLibAnswers;
        }

        public void setDevLibAnswers(List<DevLibAnswers> devLibAnswers) {
                this.devLibAnswers = devLibAnswers;
        }
}


