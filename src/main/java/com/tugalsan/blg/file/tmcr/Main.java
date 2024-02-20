package com.tugalsan.blg.file.tmcr;

import com.tugalsan.api.callable.client.TGS_CallableType1;
import com.tugalsan.api.callable.client.TGS_CallableType2;
import com.tugalsan.api.callable.client.TGS_CallableType5;
import com.tugalsan.api.file.common.server.TS_FileCommonBall;
import com.tugalsan.api.list.client.TGS_ListUtils;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.runnable.client.TGS_RunnableType1;
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

        List<String> macroLines = TGS_ListUtils.of(
                TS_FileTmcrCodePageWriter.INSERT_PAGE(4, true),
                TS_FileTmcrCodeTableWriter.BEGIN_TABLE(1),
                TS_FileTmcrCodeTableWriter.BEGIN_TABLECELL(1, 1, null),
                TS_FileTmcrCodeTextWriter.BEGIN_TEXT_LEFT(),
                TS_FileTmcrCodeTextWriter.ADD_TEXT("Tuğalsan Karabacak ♠☀☁☃☎☛ ŞşİiIıÜüÖöÇçŞşĞğ"),
                TS_FileTmcrCodeTextWriter.END_TEXT(),
                TS_FileTmcrCodeTableWriter.END_TABLECELL(),
                TS_FileTmcrCodeTableWriter.END_TABLE()
        );
        String username = "myUserName";
        String tablename = "myTableName";
        Long selectedId = 1L;

        String funcName = "MyFunctionName";
        String fileNameLabel = "MyFileNameLabel";
        TGS_Url url = TGS_Url.of("http://tugalsan.com");
        List<String> requestedFileTypes = TGS_ListUtils.of(
                TGS_FileTmcrTypes.FILE_TYPE_DOCX(),
                TGS_FileTmcrTypes.FILE_TYPE_HTM(),
                TGS_FileTmcrTypes.FILE_TYPE_HTML(),
                TGS_FileTmcrTypes.FILE_TYPE_PDF(),
                TGS_FileTmcrTypes.FILE_TYPE_TMCR(),
                TGS_FileTmcrTypes.FILE_TYPE_XLSX(),
                TGS_FileTmcrTypes.FILE_TYPE_ZIP()
        );
        Path dirDat = Path.of("D:\\xampp_data\\DAT");
        Path fontPathBold = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-Bold.ttf");
        Path fontPathBoldItalic = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-BoldItalic.ttf");
        Path fontPathItalic = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-Italic.ttf");
        Path fontPathRegular = Path.of("D:\\xampp_data\\DAT\\PUB\\FONT\\Roboto-Regular.ttf");
        TGS_Url customDomain = TGS_Url.of("https://localhost:8443");
        TGS_Url favIconPng = TGS_Url.of("https://localhost:8443/favicon/dark-16x16.png");
        String domainName = "localhost";//WHY NOT PARSE FROM customDomain(?)
        Path dirDatTbl = Path.of("D:\\xampp_data\\DAT\\TBL");
        Path dirDatPub = Path.of("D:\\xampp_data\\DAT\\PUB");
        Path dirDatUsr = Path.of("D:\\xampp_data\\DAT\\USR\\admin");
        Path dirDatUsrTmp = Path.of("D:\\xampp_data\\DAT\\USR\\admin\\tmp");
        TGS_CallableType1<TGS_Url, TGS_Url> manipulateInjectCode = _url -> _url;//SKIP LEGACY CODE
        TGS_CallableType5<List<String>, String, String, Long, String, Boolean> libTableFileList_getFileNames_DataIn = (a, b, c, d, e) -> TGS_ListUtils.of();//SKIP LEGACY CODE
        TGS_CallableType2<Path, String, String> libTableFileDir_datTblTblnameColname = (a, b) -> dirDatUsrTmp;//SKIP LEGACY CODE
        TGS_CallableType2<TGS_Url, String, Boolean> libTableFileGetUtils_urlUsrTmp = (a, b) -> favIconPng;//SKIP LEGACY CODE
        TGS_CallableType1<String, CharSequence> libTableServletUtils_URL_SERVLET_FETCH_TBL_FILE = a -> customDomain.toString();//SKIP LEGACY CODE
        TGS_CallableType1<String, CharSequence> libFileServletUtils_URL_SERVLET_FETCH_PUBLIC = a -> customDomain.toString();//SKIP LEGACY CODE
        TGS_CallableType1<String, CharSequence> libFileServletUtils_URL_SERVLET_FETCH_USER = a -> customDomain.toString();//SKIP LEGACY CODE
        var fileCommonBall = new TS_FileCommonBall(
                macroLines, username,
                tablename, selectedId,
                funcName, fileNameLabel, url,
                requestedFileTypes, dirDat,
                fontPathBold, fontPathBoldItalic, fontPathItalic, fontPathRegular,
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
        var anchor = new TS_SQLConnAnchor(new TS_SQLConnConfig("test"));
        TGS_RunnableType2<String, Integer> progressUpdate_with_userDotTable_and_percentage = (userDotTable, percentage) -> {
            var clearPercentages = percentage == TS_FileTmcrParser.CLEAR_PERCENTAGES();
            d.cr("main", "progressUpdate_with_userDotTable_and_percentage", "userDotTable", userDotTable, "percentage", clearPercentages ? "clearPercentages" : percentage);
        };
        TGS_RunnableType1<TS_FileTmcrFileHandler> exeBeforeZip = fileHandler -> {
            d.cr("main", "exeBeforeZip", "nothing to do");
        };
        TGS_RunnableType1<TS_FileTmcrFileHandler> exeAfterZip = fileHandler -> {
            d.cr("main", "exeAfterZip", "nothing to do");
        };
        var result = TS_FileTmcrFileHandler.use(
                fileCommonBall, anchor,
                progressUpdate_with_userDotTable_and_percentage,
                exeBeforeZip, exeAfterZip
        );
        d.cr("main", "result", result);
    }
}
/*
{TS_FileCommonBall}, {macroLines}, {[1685], []}
{TS_FileCommonBall}, {username}, {[admin]}
{TS_FileCommonBall}, {tablename}, {[fasongiris]}
{TS_FileCommonBall}, {selectedId}, {[23050461]}
{TS_FileCommonBall}, {funcName}, {[Giri? Formu (Üzerinde ??lem Yap?lacak Mü?teri Ürünü)]}
{TS_FileCommonBall}, {fileNameLabel}, {[Giri? Formu (Üzerinde ??lem Yap?lacak Mü?teri Ürün]}
{TS_FileCommonBall}, {url}, {[https://localhost:8443/app-table/?test=mesauser2&bif=Y2xpZW50RGF0ZSAoMjAyNDAyMjApbW96aWxsYS81LjAgKHdpbmRvd3MgbnQgMTAuMDsgd2luNjQ7IHg2NCkgYXBwbGV3ZWJraXQvNTM3LjM2IChraHRtbCwgbGlrZSBnZWNrbykgY2hyb21lLzEyMS4wLjAuMCBzYWZhcmkvNTM3LjM2IGVkZy8xMjEuMC4wLjAgc3RvcmFnZUxvY2FsX2Rlc2t0b3AgKHRydWUpIHN0b3JhZ2VTZXNzaW9uX2Rlc2t0b3AgKHRydWUpIGlzT3JpZW50YXRpb25VbmRlZmluZWQgKHRydWUpIGlzTW9iaWxlIChmYWxzZSkgZGVwdGhDb2xvciAoMjQpIGRlcHRoUGl4ZWwgKDI0KSB3aWR0aFNjcmVlbiAoMTI4MCkgaGVpZ2h0U2NyZWVuICg3MjAp&ctk=WzE3MDg0MjEwOTM2NDhdLCBbN2YzODEyYzgtYjM0My00MjM0LThkMWEtZjA5ZmVkMDQ0NWE3XSwgW05udy1wcHRHVERQSFQ1Z05d&acf=Y2xpZW50VG9rZW4tPlsxNzA4NDIxMDkzNjQ4XSwgWzdmMzgxMmM4LWIzNDMtNDIzNC04ZDFhLWYwOWZlZDA0NDVhN10sIFtObnctcHB0R1REUEhUNWdOXSwgc2VydmVyVG9rZW4tPlsxNzA4NDIxMDkzODU0XSwgW0RDQzUyMkQ2QzQyNzY4ODAzQzM2REU3OTU0N0Y5QTk3NDc5RTM3QjczQjEwMzMyODI5QkJFN0JDMTQzNDE4OENdLCBbT3UwRThDLXhITTRCV2NkTG8tWFc3aEZXU1AzbUNkd0hfNktvQTZHa0VvNlRKQzdHaDJpdW14T2dEcDl2ZkJMS29laFR3SjhPcHg3dC0tc1lCU0tyUm94N1Y2SGt4U3NnLXdGMy53V2VVVm43QVA0LjZBZnlGeDhmNWs2MEo1bVhlVGRBWXVIZXk5c0JZNHJQVDdkTXpOQ29GMEV6a19iOTZrMnBiQ2otLS1vaFdmeERUWXdKM21kbVlGRHhZREFjUHVhWkY1RmRmTUU4SDNPZFNHY1k0dGtZZVQ5N0tiTHh2d2hFaG5ENFNvLWZhTG13eEZkRWlEZS5pQmlrUFBHZFY3R3dYRkhaQWdaVWIzSmFiVzR5T0pKLks2WnhXWkYtS1hNZy13WFp2aEdCaXUzc00wWFdCLW00ak5YZW5vc1drYk4zaDhKSEVoX2ZLM28udlBSWjZ2a2pjaTU3YmtELU5fY1l5QXZlX3NLejZKZGdVV3NraVVwdFpmeC5kWFZPXSwgW1BsZWFzZSBkbyBub3QgaGFjayBtZSA6KV0.&app=bGFtYmRhJDEkVHlwZQ..&mdl=QXBwTW9kdWxlVGFibGU.&CURRENT_TABLE_NAME=ZmFzb25naXJpcw..&CELLS_ROW_SIZE=MTI.]}
{TS_FileCommonBall}, {requestedFileTypes}, {[0], [.htm]}
{TS_FileCommonBall}, {requestedFileTypes}, {[1], [.pdf]}
{TS_FileCommonBall}, {requestedFileTypes}, {[2], [.html]}
{TS_FileCommonBall}, {fontPathBold}, {[D:\xampp_data\DAT\PUB\FONT\Roboto-Bold.ttf]}
{TS_FileCommonBall}, {fontPathBoldItalic}, {[D:\xampp_data\DAT\PUB\FONT\Roboto-BoldItalic.ttf]}
{TS_FileCommonBall}, {fontPathItalic}, {[D:\xampp_data\DAT\PUB\FONT\Roboto-Italic.ttf]}
{TS_FileCommonBall}, {fontPathRegular}, {[D:\xampp_data\DAT\PUB\FONT\Roboto-Regular.ttf]}
{TS_FileCommonBall}, {customDomain}, {[https://localhost:8443]}
{TS_FileCommonBall}, {favIconPng}, {[https://localhost:8443/res-other/res/mesametal_com/favicon/mesametal-dark-16x16.png]}
{TS_FileCommonBall}, {domainName}, {[localhost]}
{TS_FileCommonBall}, {manipulateInjectCode}, {[true]}
{TS_FileCommonBall}, {dirDatTbl}, {[D:\xampp_data\DAT\TBL]}
{TS_FileCommonBall}, {dirDatPub}, {[D:\xampp_data\DAT\PUB]}
{TS_FileCommonBall}, {dirDatUsr}, {[D:\xampp_data\DAT\USR\admin]}
{TS_FileCommonBall}, {dirDatUsrTmp}, {[D:\xampp_data\DAT\USR\admin\tmp]}
{TS_FileCommonBall}, {dirDatTbl}, {[D:\xampp_data\DAT\TBL]}
{TS_FileCommonBall}, {dirDatTbl}, {[D:\xampp_data\DAT\TBL]}
{TS_FileCommonBall}, {libTableFileList_getFileNames_DataIn}, {[true]}
{TS_FileCommonBall}, {libTableFileDir_datTblTblnameColname}, {[true]}
{TS_FileCommonBall}, {libTableFileGetUtils_urlUsrTmp}, {[true]}
{TS_FileCommonBall}, {libTableServletUtils_URL_SERVLET_FETCH_TBL_FILE}, {[true]}
{TS_FileCommonBall}, {libFileServletUtils_URL_SERVLET_FETCH_PUBLIC}, {[true]}
{TS_FileCommonBall}, {libFileServletUtils_URL_SERVLET_FETCH_USER}, {[true]}
 */
