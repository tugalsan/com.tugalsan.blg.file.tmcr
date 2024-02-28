package com.tugalsan.blg.file.tmcr;

import com.tugalsan.api.callable.client.TGS_CallableType1;
import com.tugalsan.api.callable.client.TGS_CallableType2;
import com.tugalsan.api.callable.client.TGS_CallableType5;
import com.tugalsan.api.file.common.server.TS_FileCommonConfig;
import com.tugalsan.api.list.client.TGS_ListUtils;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.runnable.client.TGS_RunnableType2;
import com.tugalsan.api.sql.conn.server.TS_SQLConnAnchor;
import com.tugalsan.api.sql.conn.server.TS_SQLConnConfig;
import com.tugalsan.api.url.client.TGS_Url;
import com.tugalsan.lib.file.tmcr.client.TGS_FileTmcrTypes;
import com.tugalsan.lib.file.tmcr.server.code.page.TS_FileTmcrCodePageWriter;
import com.tugalsan.lib.file.tmcr.server.code.parser.TS_FileTmcrParser;
import com.tugalsan.lib.file.tmcr.server.code.table.TS_FileTmcrCodeTableWriter;
import com.tugalsan.lib.file.tmcr.server.code.text.TS_FileTmcrCodeTextWriter;
import com.tugalsan.lib.file.tmcr.server.file.TS_FileTmcrFileHandler;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final TS_Log d = TS_Log.of(true, Main.class);

    //cd C:\me\codes\com.tugalsan\tst\com.tugalsan.blg.file.tmcr
    //java --enable-preview --add-modules jdk.incubator.vector -jar target/com.tugalsan.blg.file.tmcr-1.0-SNAPSHOT-jar-with-dependencies.jar
    public static void main(String... s) {
        var text = "Tuğalsan Karabacak ♠☀☁☃☎☛ ŞşİiIıÜüÖöÇçŞşĞğ";
        TS_FileTmcrFileHandler.enablePreviewPanLetters = true;
        TS_FileTmcrFileHandler.d.infoEnable = true;
//        TGS_UnSafe.run(() -> {//TEST canDisplay
//            var fontPathRegular = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-Regular.ttf");
//            var fontPathPanUnicode = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Code2000-rdLO.ttf");
//            var fontRegular = Font.createFont(Font.TRUETYPE_FONT, fontPathRegular.toFile()).deriveFont(12f);
//            var fontPanUnicode = Font.createFont(Font.TRUETYPE_FONT, fontPathPanUnicode.toFile()).deriveFont(12f);
//            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fontRegular);
//            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fontPanUnicode);
//            var codePoints = text.codePoints().toArray();
//            var sb = new StringBuilder();
//            IntStream.range(0, codePoints.length).forEachOrdered(idx -> {
//                var codePoint = codePoints[idx];
//                sb.setLength(0);
//                sb.appendCodePoint(codePoint);
//                var letter = sb.toString();
//                d.cr("letterTest", idx, letter, fontRegular.canDisplay(codePoint), fontPanUnicode.canDisplay(codePoint));
//            });
//        });
//        if (true) {
//            return;
//        }
        List<String> macroLines = TGS_ListUtils.of(
                TS_FileTmcrCodePageWriter.INSERT_PAGE(4, true),
                TS_FileTmcrCodeTableWriter.BEGIN_TABLE(1),
                TS_FileTmcrCodeTableWriter.BEGIN_TABLECELL(1, 1, null),
                TS_FileTmcrCodeTextWriter.BEGIN_TEXT_LEFT(),
                TS_FileTmcrCodeTextWriter.ADD_TEXT(text),
                TS_FileTmcrCodeTextWriter.END_TEXT(),
                TS_FileTmcrCodeTableWriter.END_TABLECELL(),
                TS_FileTmcrCodeTableWriter.END_TABLE()
        );
        var result = TS_FileTmcrFileHandler.use(toConfig(macroLines), createDbAnchor("test"), progressUpdate);
        d.cr("main", "result", result);
    }

    private static TGS_RunnableType2<String, Integer> progressUpdate = (userDotTable, percentage) -> {
        var value = percentage == TS_FileTmcrParser.CLEAR_PERCENTAGES() ? "clearPercentages" : percentage;
        d.cr("main", "progressUpdate_with_userDotTable_and_percentage", "userDotTable", userDotTable, "percentage", value);
    };

    private static TS_SQLConnAnchor createDbAnchor(String dbName) {
        return TS_SQLConnAnchor.of(TS_SQLConnConfig.of(dbName));
    }

    private static TS_FileCommonConfig toConfig(List<String> macroLines) {
        var username = "myUserName";
        var tablename = "myTableName";
        var selectedId = 1L;

        var funcName = "MyFunctionName";
        var fileNameLabel = "MyFileNameLabel";
        var url = TGS_Url.of("http://tugalsan.com");
        List<String> requestedFileTypes = TGS_ListUtils.of(
                TGS_FileTmcrTypes.FILE_TYPE_DOCX(),
                TGS_FileTmcrTypes.FILE_TYPE_HTM(),
                TGS_FileTmcrTypes.FILE_TYPE_HTML(),
                TGS_FileTmcrTypes.FILE_TYPE_PDF(),
                TGS_FileTmcrTypes.FILE_TYPE_TMCR(),
                TGS_FileTmcrTypes.FILE_TYPE_XLSX(),
                TGS_FileTmcrTypes.FILE_TYPE_ZIP()
        );
        var dirDat = Path.of("D:\\xampp_data\\DAT");
        var fontPathBold = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-Bold.ttf");
        var fontPathBoldItalic = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-BoldItalic.ttf");
        var fontPathItalic = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-Italic.ttf");
        var fontPathRegular = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-Regular.ttf");
        var fontPathPanUnicode = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Code2000-rdLO.ttf");
        var customDomain = TGS_Url.of("https://localhost:8443");
        var favIconPng = TGS_Url.of("https://localhost:8443/favicon/dark-16x16.png");
        var domainName = "localhost";//WHY NOT PARSE FROM customDomain(?)
        var dirDatTbl = Path.of("D:\\xampp_data\\DAT\\TBL");
        var dirDatPub = Path.of("D:\\xampp_data\\DAT\\PUB");
        var dirDatUsr = Path.of("D:\\xampp_data\\DAT\\USR\\admin");
        var dirDatUsrTmp = Path.of("D:\\xampp_data\\DAT\\USR\\admin\\tmp");
        TGS_CallableType1<TGS_Url, TGS_Url> manipulateInjectCode = _url -> _url;//SKIP LEGACY CODE
        TGS_CallableType5<List<String>, String, String, Long, String, Boolean> libTableFileList_getFileNames_DataIn = (a, b, c, d, e) -> TGS_ListUtils.of();//SKIP LEGACY CODE
        TGS_CallableType2<Path, String, String> libTableFileDir_datTblTblnameColname = (a, b) -> dirDatUsrTmp;//SKIP LEGACY CODE
        TGS_CallableType2<TGS_Url, String, Boolean> libTableFileGetUtils_urlUsrTmp = (a, b) -> favIconPng;//SKIP LEGACY CODE
        TGS_CallableType1<String, CharSequence> libTableServletUtils_URL_SERVLET_FETCH_TBL_FILE = a -> customDomain.toString();//SKIP LEGACY CODE
        TGS_CallableType1<String, CharSequence> libFileServletUtils_URL_SERVLET_FETCH_PUBLIC = a -> customDomain.toString();//SKIP LEGACY CODE
        TGS_CallableType1<String, CharSequence> libFileServletUtils_URL_SERVLET_FETCH_USER = a -> customDomain.toString();//SKIP LEGACY CODE
        return new TS_FileCommonConfig(
                macroLines, username,
                tablename, selectedId,
                funcName, fileNameLabel, url,
                requestedFileTypes, dirDat,
                fontPathBold, fontPathBoldItalic, fontPathItalic, fontPathRegular, fontPathPanUnicode,
                customDomain, favIconPng, domainName,
                manipulateInjectCode,
                dirDatTbl, dirDatPub, dirDatUsr, dirDatUsrTmp,
                libTableFileList_getFileNames_DataIn,
                libTableFileDir_datTblTblnameColname,
                libTableFileGetUtils_urlUsrTmp,
                libTableServletUtils_URL_SERVLET_FETCH_TBL_FILE,
                libFileServletUtils_URL_SERVLET_FETCH_PUBLIC,
                libFileServletUtils_URL_SERVLET_FETCH_USER
        );
    }
}
