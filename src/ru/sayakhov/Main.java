package ru.sayakhov;

import ru.sayakhov.methods.ReaderEncoder;
import ru.sayakhov.methods.WriteEncoder;

import java.io.*;

/**
 * 1. Написать программу, которая копирует файл с одной кодировкой в файл с другой.
 * <p>
 * 2. Написать программу, которая удаляет из некоторого текста номера сотовых телефонов. Для простоты все номера сотовых телефонов состоят из 11 цифр подряд.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        File bookPath = new File("Phone Book.txt");

        FileWriter fileWriter = new FileWriter(bookPath, true);
        BufferedReader fr = null;

        fileWriter.write("\n Тимур 89178702345 Олег 89178702345 Федор 89178702345 Катя 21/21/2018 ");
        fileWriter.write("Витя 89178702345");
        fileWriter.write("\n" + "Тузик 89172354534"); // не понимаю почему обрезается 1я буква в предложении
        fileWriter.write(" Иван 89439857238");
        fileWriter.close();

        try {
            fr = new BufferedReader(new FileReader(bookPath));
            while (fr.read() != -1) {
                String text = fr.readLine();
                String[] textArray = text.split(" ");
                StringBuilder newText = new StringBuilder();
                for ( int i = 0; i < textArray.length; i++ ) {
                    if (check(textArray[i])) {
                        continue;
                    } else {
                        newText.append(" ");
                        newText.append(textArray[i]);
                    }
                }
                System.out.println(newText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Конвектор кодировки файла
         * 1 парамент получает байт код от InputStreamReader
         * 2 параментром мы указываем куда и в какой кодировке записать файл
         */
        WriteEncoder.writeOutput(ReaderEncoder.readInput("Phone Book.txt"),"Phone Book1.txt");
    }

    public static Boolean check(String text) {
        for ( int i = 0; i < text.length(); i++ ) {
            if (Character.isDigit(text.charAt(i)) && text.length() == 11) {
                return true;
            }
        }
        return false;
    }

}
