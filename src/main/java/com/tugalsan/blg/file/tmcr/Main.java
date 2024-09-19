package com.tugalsan.blg.file.tmcr;

import com.tugalsan.api.function.client.TGS_Func_OutTyped_In1;
import com.tugalsan.api.file.common.client.TGS_FileCommonFavIcon;
import com.tugalsan.api.file.common.server.TS_FileCommonConfig;
import com.tugalsan.api.font.client.TGS_FontFamily;
import com.tugalsan.api.function.client.TGS_Func_In2;
import com.tugalsan.api.list.client.TGS_ListUtils;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.sql.conn.server.TS_SQLConnAnchor;
import com.tugalsan.api.sql.conn.server.TS_SQLConnConfig;
import com.tugalsan.api.url.client.TGS_Url;
import com.tugalsan.lib.file.tmcr.client.TGS_LibFileTmcrTypes;
import com.tugalsan.lib.file.tmcr.server.code.font.TS_LibFileTmcrCodeFontWriter;
import com.tugalsan.lib.file.tmcr.server.code.page.TS_LibFileTmcrCodePageWriter;
import com.tugalsan.lib.file.tmcr.server.code.parser.TS_LibFileTmcrParser;
import com.tugalsan.lib.file.tmcr.server.code.table.TS_LibFileTmcrCodeTableWriter;
import com.tugalsan.lib.file.tmcr.server.code.text.TS_LibFileTmcrCodeTextWriter;
import com.tugalsan.lib.file.tmcr.server.file.TS_LibFileTmcrFileHandler;
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
        TS_LibFileTmcrFileHandler.d.infoEnable = true;
        List<String> macroCode = TGS_ListUtils.of(
                TS_LibFileTmcrCodePageWriter.INSERT_PAGE(4, true),
                TS_LibFileTmcrCodeTableWriter.BEGIN_TABLE(1),
                TS_LibFileTmcrCodeTableWriter.BEGIN_TABLECELL(1, 1, null),
                TS_LibFileTmcrCodeTextWriter.BEGIN_TEXT_LEFT(),
                TS_LibFileTmcrCodeTextWriter.ADD_TEXT(text),
                TS_LibFileTmcrCodeTextWriter.ADD_TEXT_NEWLINE(),
                TS_LibFileTmcrCodeFontWriter.SET_FONT_COLOR_RED(),
                TS_LibFileTmcrCodeFontWriter.SET_FONT_STYLE_BOLD(),
                TS_LibFileTmcrCodeTextWriter.ADD_TEXT(text),
                TS_LibFileTmcrCodeTextWriter.END_TEXT(),
                TS_LibFileTmcrCodeTableWriter.END_TABLECELL(),
                TS_LibFileTmcrCodeTableWriter.END_TABLE()
        );
        var config = toConfig(favIconText, macroCode);
        var result = TS_LibFileTmcrFileHandler.use(
                config,
                createDbAnchor("test"),
                progressUpdate,
                timeout
        );
        d.cr("main", "result", result);
        d.cr("toConfig", "see files at", config.dirDatUsrTmp);
    }

    private static final TGS_Func_In2<String, Integer> progressUpdate = (userDotTable, percentage) -> {
        var value = percentage == TS_LibFileTmcrParser.CLEAR_PERCENTAGES() ? "clearPercentages" : percentage;
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
        List<String> requestedFileTypes = TGS_ListUtils.of(TGS_LibFileTmcrTypes.FILE_TYPE_DOCX(),
                TGS_LibFileTmcrTypes.FILE_TYPE_HTM(),
                TGS_LibFileTmcrTypes.FILE_TYPE_HTML(),
                TGS_LibFileTmcrTypes.FILE_TYPE_PDF(),
                TGS_LibFileTmcrTypes.FILE_TYPE_TMCR(),
                TGS_LibFileTmcrTypes.FILE_TYPE_XLSX(),
                TGS_LibFileTmcrTypes.FILE_TYPE_ZIP()
        );
        var dirDat = Path.of("C:", "dat", "dat");
        var dirDatTbl = dirDat.resolve("tbl");
        var dirDatPub = dirDat.resolve("pub");
        var dirDatPubFont = dirDatPub.resolve("font");
        var dirDatUsr = dirDat.resolve("usr").resolve("admin");
        var dirDatUsrTmp = dirDatUsr.resolve("tmp");
        TGS_Func_OutTyped_In1<Path, String> fontPath = fontFileName -> dirDatPubFont.resolve(fontFileName);
        List<TGS_FontFamily<Path>> fontFamilyPaths = TGS_ListUtils.of(
                new TGS_FontFamily(fontPath.call("Roboto-Regular.ttf"), fontPath.call("Roboto-Bold.ttf"), fontPath.call("Roboto-Italic.ttf"), fontPath.call("Roboto-BoldItalic.ttf")),
                new TGS_FontFamily(fontPath.call("FreeSerif.ttf"), fontPath.call("FreeSerifBold.ttf"), fontPath.call("FreeSerifItalic.ttf"), fontPath.call("FreeSerifBoldItalic.ttf")),
                new TGS_FontFamily(fontPath.call("Quivira-A8VL.ttf"), fontPath.call("Quivira-A8VL.ttf"), fontPath.call("Quivira-A8VL.ttf"), fontPath.call("Quivira-A8VL.ttf")),
                new TGS_FontFamily(fontPath.call("Code2000-rdLO.ttf"), fontPath.call("Code2000-rdLO.ttf"), fontPath.call("Code2000-rdLO.ttf"), fontPath.call("Code2000-rdLO.ttf"))
        );
        var favIcon = TGS_FileCommonFavIcon.ofTxt(favIconText, null, false);
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
