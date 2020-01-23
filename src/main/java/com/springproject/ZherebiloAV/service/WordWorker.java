package com.springproject.ZherebiloAV.service;

import com.springproject.ZherebiloAV.domain.Employee;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

@Service
public class WordWorker {

    public void createEmployeeReport(Employee employee) throws IOException, InvalidFormatException {
        XWPFDocument document = new XWPFDocument(); //создание нового документа
        FileOutputStream out = new FileOutputStream(new File("reports/Отчёт о сотруднике." + employee.getPassport().getSurname() + "- От " + Calendar.getInstance().getTime().getTime() + ".docx"));

        XWPFParagraph paragraph = document.createParagraph(); //создание нового параграфа
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run = paragraph.createRun(); //область текста с набором свойств
        run.setFontSize(14);
        run.setText(employee.getPassport().getSurname() + " " + employee.getPassport().getName());
        String imgFile = "uploads/" + employee.getPhoto();
        FileInputStream is = new FileInputStream(imgFile);
        run.addBreak();
        run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
        is.close();

        document.write(out);
        out.close();
    }
}
