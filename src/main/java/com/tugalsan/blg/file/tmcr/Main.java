package com.tugalsan.blg.file.tmcr;

import com.tugalsan.api.callable.client.TGS_CallableType1;
import com.tugalsan.api.file.common.client.TGS_FileCommonFavIcon;
import com.tugalsan.api.file.common.server.TS_FileCommonConfig;
import com.tugalsan.api.font.client.TGS_FontFamily;
import com.tugalsan.api.list.client.TGS_ListUtils;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.runnable.client.TGS_RunnableType2;
import com.tugalsan.api.sql.conn.server.TS_SQLConnAnchor;
import com.tugalsan.api.sql.conn.server.TS_SQLConnConfig;
import com.tugalsan.api.url.client.TGS_Url;
import com.tugalsan.lib.file.tmcr.client.TGS_FileTmcrTypes;
import com.tugalsan.lib.file.tmcr.server.code.font.TS_FileTmcrCodeFontWriter;
import com.tugalsan.lib.file.tmcr.server.code.page.TS_FileTmcrCodePageWriter;
import com.tugalsan.lib.file.tmcr.server.code.parser.TS_FileTmcrParser;
import com.tugalsan.lib.file.tmcr.server.code.table.TS_FileTmcrCodeTableWriter;
import com.tugalsan.lib.file.tmcr.server.code.text.TS_FileTmcrCodeTextWriter;
import com.tugalsan.lib.file.tmcr.server.file.TS_FileTmcrFileHandler;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;

public class Main {

    private static final TS_Log d = TS_Log.of(true, Main.class);

    //cd C:\me\codes\com.tugalsan\tst\com.tugalsan.blg.file.tmcr
    //java --enable-preview --add-modules jdk.incubator.vector -jar target/com.tugalsan.blg.file.tmcr-1.0-SNAPSHOT-jar-with-dependencies.jar
    public static void main(String... s) {
        var text = "Tuğalsan Karabacak ♠☀☁☃☎☛ ŞşİiIıÜüÖöÇçŞşĞğ";
        var favIconText = "☃";
        var timeout = Duration.ofSeconds(30);
        TS_FileTmcrFileHandler.d.infoEnable = true;
        var u_config = toConfig(favIconText, TGS_ListUtils.of(
                TS_FileTmcrCodePageWriter.INSERT_PAGE(4, true),
                TS_FileTmcrCodeTableWriter.BEGIN_TABLE(1),
                TS_FileTmcrCodeTableWriter.BEGIN_TABLECELL(1, 1, null),
                TS_FileTmcrCodeTextWriter.BEGIN_TEXT_LEFT(),
                TS_FileTmcrCodeTextWriter.ADD_TEXT(text),
                TS_FileTmcrCodeTextWriter.ADD_TEXT_NEWLINE(),
                TS_FileTmcrCodeFontWriter.SET_FONT_COLOR_RED(),
                TS_FileTmcrCodeFontWriter.SET_FONT_STYLE_BOLD(),
                TS_FileTmcrCodeTextWriter.ADD_TEXT(text),
                TS_FileTmcrCodeTextWriter.END_TEXT(),
                TS_FileTmcrCodeTableWriter.END_TABLECELL(),
                TS_FileTmcrCodeTableWriter.END_TABLE()
        ));
//        if (u_config.isExcuse()) {
//            d.ce("main", u_config.excuse());
//        }
        var result = TS_FileTmcrFileHandler.use(
//                u_config.value(),
                u_config,
                createDbAnchor("test"),
                progressUpdate,
                timeout
        );
        d.cr("main", "result", result);
        d.cr("toConfig", "see files at", u_config.dirDatUsrTmp);
//        d.cr("toConfig", "see files at", u_config.value().dirDatUsrTmp);
//        TS_FontUtils.listRegisteredFontNames().forEach(fn -> d.cr("main", fn));
    }

    private static final TGS_RunnableType2<String, Integer> progressUpdate = (userDotTable, percentage) -> {
        var value = percentage == TS_FileTmcrParser.CLEAR_PERCENTAGES() ? "clearPercentages" : percentage;
        d.cr("main", "progressUpdate_with_userDotTable_and_percentage", "userDotTable", userDotTable, "percentage", value);
    };

    private static TS_SQLConnAnchor createDbAnchor(String dbName) {
        return TS_SQLConnAnchor.of(TS_SQLConnConfig.of(dbName));
    }

    private static TS_FileCommonConfig toConfig(String favIconText, List<String> macroLines) {
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
        TGS_CallableType1<Path, String> fontPath = fontFileName -> Path.of("D:", "xampp_data", "DAT", "PUB", "FONT", fontFileName);
        List<TGS_FontFamily<Path>> fontFamilyPaths = TGS_ListUtils.of(
                new TGS_FontFamily(fontPath.call("Roboto-Regular.ttf"), fontPath.call("Roboto-Bold.ttf"), fontPath.call("Roboto-Italic.ttf"), fontPath.call("Roboto-BoldItalic.ttf")),
                new TGS_FontFamily(fontPath.call("FreeSerif.ttf"), fontPath.call("FreeSerifBold.ttf"), fontPath.call("FreeSerifItalic.ttf"), fontPath.call("FreeSerifBoldItalic.ttf")),
                new TGS_FontFamily(fontPath.call("Quivira-A8VL.ttf"), fontPath.call("Quivira-A8VL.ttf"), fontPath.call("Quivira-A8VL.ttf"), fontPath.call("Quivira-A8VL.ttf")),
                new TGS_FontFamily(fontPath.call("Code2000-rdLO.ttf"), fontPath.call("Code2000-rdLO.ttf"), fontPath.call("Code2000-rdLO.ttf"), fontPath.call("Code2000-rdLO.ttf"))
        );
        var favIcon = TGS_FileCommonFavIcon.ofTxt(favIconText, null, false);
        var dirDatTbl = Path.of("D:\\xampp_data\\DAT\\TBL");
        var dirDatPub = Path.of("D:\\xampp_data\\DAT\\PUB");
        var dirDatUsr = Path.of("D:\\xampp_data\\DAT\\USR\\admin");
        var dirDatUsrTmp = Path.of("D:\\xampp_data\\DAT\\USR\\admin\\tmp");
        return TS_FileCommonConfig.of(
                macroLines, username,
                tablename, selectedId,
                funcName, fileNameLabel, url,
                requestedFileTypes, dirDat,
                fontFamilyPaths,
                favIcon,
                dirDatTbl, dirDatPub, dirDatUsr, dirDatUsrTmp,
                null
        );
    }
}
