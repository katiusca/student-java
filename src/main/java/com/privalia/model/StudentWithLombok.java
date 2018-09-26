package com.privalia.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class StudentWithLombok extends PrivaliaObject {
    @NonNull
    private Integer idStudent;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private Integer age;

    public static StudentWithLombok getStudent() {
        return new StudentWithLombok();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(idStudent);
        sb.append(",").append(name);
        sb.append(",").append(surname);
        sb.append(",").append(age);
        return sb.toString();
    }
}
