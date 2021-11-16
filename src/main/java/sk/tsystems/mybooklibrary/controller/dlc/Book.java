package sk.tsystems.mybooklibrary.controller.dlc;

import lombok.Data;
import lombok.Setter;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//@AllArgsConstructor
@Data
public class Book {
//    @Getter
//    @Setter
    private final String title;
//    @Getter
//    @Setter
    private final String author;

    public static void main(String[] args) {
        Book book = new Book(" "," ");
    }

}
