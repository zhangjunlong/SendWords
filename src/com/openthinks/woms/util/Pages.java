package com.openthinks.woms.util;

import javax.servlet.http.HttpServletRequest;

public class Pages
{

    public Pages(HttpServletRequest request)
    {
        this.request = null;
        pageLink = "";
        page = 1;
        totals = 0;
        perpagenum = 10;
        style = 0;
        allpage = 0;
        cpage = 1;
        srecords = 0;
        webLinkStr = "";
        webJumpStr = "";
        webInfoStr = "";
        webScriptStr = "";
        buttonStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #bbb 1px solid; BACKGROUND: #ece9d8; BORDER-LEFT: #bbb 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        inputStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #555 1px solid; BORDER-LEFT: #555 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        formName = null;
        this.request = request;
        String queryStr = request.getQueryString();
        StringBuffer queryURL = request.getRequestURL();
        if(queryStr != null)
        {
            if(queryStr.indexOf("page=") != -1)
                pageLink = queryURL.append((new StringBuilder("?")).append(queryStr.substring(0, queryStr.indexOf("page=") - 1)).toString()).toString();
            else
                pageLink = queryURL.append((new StringBuilder("?")).append(queryStr).toString()).toString();
        } else
        {
            pageLink = queryURL.toString();
        }
        if(request.getParameter("page") != null && !request.getParameter("page").trim().equals(""))
            page = Integer.parseInt(request.getParameter("page"));
        if(request.getParameter("t") != null && !request.getParameter("t").trim().equals(""))
            totals = Integer.parseInt(request.getParameter("t"));
    }

    public Pages(HttpServletRequest request, int perpagenum, int style)
    {
        this.request = null;
        pageLink = "";
        page = 1;
        totals = 0;
        this.perpagenum = 10;
        this.style = 0;
        allpage = 0;
        cpage = 1;
        srecords = 0;
        webLinkStr = "";
        webJumpStr = "";
        webInfoStr = "";
        webScriptStr = "";
        buttonStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #bbb 1px solid; BACKGROUND: #ece9d8; BORDER-LEFT: #bbb 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        inputStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #555 1px solid; BORDER-LEFT: #555 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        formName = null;
        this.request = request;
        String queryStr = request.getQueryString();
        StringBuffer queryURL = request.getRequestURL();
        if(queryStr != null)
        {
            if(queryStr.indexOf("page=") != -1)
                pageLink = queryURL.append((new StringBuilder("?")).append(queryStr.substring(0, queryStr.indexOf("page=") - 1)).toString()).toString();
            else
                pageLink = queryURL.append((new StringBuilder("?")).append(queryStr).toString()).toString();
        } else
        {
            pageLink = queryURL.toString();
        }
        if(request.getParameter("page") != null && !request.getParameter("page").trim().equals(""))
            page = Integer.parseInt(request.getParameter("page"));
        if(request.getParameter("t") != null && !request.getParameter("t").trim().equals(""))
            totals = Integer.parseInt(request.getParameter("t"));
        this.perpagenum = perpagenum;
        this.style = style;
    }

    public Pages(HttpServletRequest request, int totals, int perpagenum, int style)
    {
        this.request = null;
        pageLink = "";
        page = 1;
        this.totals = 0;
        this.perpagenum = 10;
        this.style = 0;
        allpage = 0;
        cpage = 1;
        srecords = 0;
        webLinkStr = "";
        webJumpStr = "";
        webInfoStr = "";
        webScriptStr = "";
        buttonStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #bbb 1px solid; BACKGROUND: #ece9d8; BORDER-LEFT: #bbb 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        inputStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #555 1px solid; BORDER-LEFT: #555 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        formName = null;
        this.request = request;
        String queryStr = request.getQueryString();
        StringBuffer queryURL = request.getRequestURL();
        if(queryStr != null)
        {
            if(queryStr.indexOf("page=") != -1)
                pageLink = queryURL.append((new StringBuilder("?")).append(queryStr.substring(0, queryStr.indexOf("page=") )).toString()).toString();
            else
                pageLink = queryURL.append((new StringBuilder("?")).append(queryStr).toString()).toString();
        } else
        {
            pageLink = queryURL.toString();
        }
        if(request.getParameter("page") != null && !request.getParameter("page").trim().equals(""))
            page = Integer.parseInt(request.getParameter("page"));
        this.totals = totals;
        this.perpagenum = perpagenum;
        this.style = style;
    }

    public Pages(int totals, int perpagenum, int style)
    {
        request = null;
        pageLink = "";
        page = 1;
        this.totals = 0;
        this.perpagenum = 10;
        this.style = 0;
        allpage = 0;
        cpage = 1;
        srecords = 0;
        webLinkStr = "";
        webJumpStr = "";
        webInfoStr = "";
        webScriptStr = "";
        buttonStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #bbb 1px solid; BACKGROUND: #ece9d8; BORDER-LEFT: #bbb 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        inputStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #555 1px solid; BORDER-LEFT: #555 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        formName = null;
        this.totals = totals;
        this.perpagenum = perpagenum;
        this.style = style;
    }

    public Pages(int page, int totals, int perpagenum, int style)
    {
        request = null;
        pageLink = "";
        this.page = 1;
        this.totals = 0;
        this.perpagenum = 10;
        this.style = 0;
        allpage = 0;
        cpage = 1;
        srecords = 0;
        webLinkStr = "";
        webJumpStr = "";
        webInfoStr = "";
        webScriptStr = "";
        buttonStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #bbb 1px solid; BACKGROUND: #ece9d8; BORDER-LEFT: #bbb 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        inputStyle = "FONT-SIZE: 12px;BORDER-RIGHT: #555 1px solid; BORDER-TOP: #555 1px solid; BORDER-LEFT: #555 1px solid; BORDER-BOTTOM: #555 1px solid; HEIGHT: 20px";
        formName = null;
        this.page = page;
        this.totals = totals;
        this.perpagenum = perpagenum;
        this.style = style;
    }

    public String getPageLink()
    {
        return pageLink;
    }

    public void setPageLink(String PageLink)
    {
        pageLink = PageLink;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int aPage)
    {
        page = aPage;
    }

    public int getTotals()
    {
        return totals;
    }

    public void setTotals(int aTotals)
    {
        totals = aTotals;
    }

    public int getPerpagenum()
    {
        return perpagenum;
    }

    public void setPerpagenum(int perpagenum)
    {
        this.perpagenum = perpagenum;
    }

    public int getStyle()
    {
        return style;
    }

    public void setStyle(int aStyle)
    {
        style = aStyle;
    }

    public void setPagesign(String apagesign[])
    {
        pagesign = apagesign;
    }

    public HttpServletRequest getRequest()
    {
        return request;
    }

    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    public String getButtonStyle()
    {
        return buttonStyle;
    }

    public void setButtonStyle(String buttonStyle)
    {
        this.buttonStyle = buttonStyle;
    }

    public String getInputStyle()
    {
        return buttonStyle;
    }

    public void setInputStyle(String buttonStyle)
    {
        this.buttonStyle = buttonStyle;
    }

    public int getSrecords()
    {
        return srecords;
    }

    public String getWebInfoStr()
    {
        return webInfoStr;
    }

    public void setFormName(String formName)
    {
        this.formName = formName;
    }

    public void setWebScriptStr(String webScriptStr)
    {
        this.webScriptStr = webScriptStr;
    }

    public String getFormName()
    {
        return formName;
    }

    public String getWebScriptStr()
    {
        return webScriptStr;
    }

    public String getWebJumpStr()
    {
        return webJumpStr;
    }

    public String getWebLinkStr()
    {
        return webLinkStr;
    }

    public void doPageBreak()
    {
        if(perpagenum == 0)
            allpage = 0;
        else
            allpage = (int)Math.ceil(((totals + perpagenum) - 1) / perpagenum);
        int intPage = page;
        if(intPage > allpage)
            cpage = 1;
        else
            cpage = intPage;
        srecords = (cpage - 1) * perpagenum;
        if(pageLink.indexOf("?") == -1)
            pageLink = (new StringBuilder(String.valueOf(pageLink))).append("?").toString();
        else
        if(!pageLink.endsWith("&"))
            pageLink = (new StringBuilder(String.valueOf(pageLink))).append("&").toString();
        getPageBreakStr();
    }

    private void getPageBreakStr()
    {
        if(style == 0)
        {
            webLinkStr = getPageBreakLinkString();
            return;
        }
        if(style == 1)
        {
            webLinkStr = getPageBreakLinkString();
            webInfoStr = getPageBreakInfoString();
            return;
        }
        if(style == 2)
        {
            webLinkStr = getPageBreakLinkString();
            webInfoStr = getPageBreakInfoString();
            webJumpStr = getPageBreakJumpButtonString();
            return;
        }
        if(style == 3)
        {
            webLinkStr = getPageBreakLinkString();
            webInfoStr = getPageBreakInfoString();
            webJumpStr = getPageBreakSelectButtonString();
            return;
        }
        if(style == 4)
        {
            webLinkStr = getPageBreakButtonString();
            return;
        }
        if(style == 5)
        {
            webLinkStr = getPageBreakButtonString();
            webInfoStr = getPageBreakInfoString();
            return;
        }
        if(style == 6)
        {
            webLinkStr = getPageBreakButtonString();
            webInfoStr = getPageBreakInfoString();
            webJumpStr = getPageBreakJumpButtonString();
            return;
        }
        if(style == 7)
        {
            webLinkStr = getPageBreakButtonString();
            webInfoStr = getPageBreakInfoString();
            webJumpStr = getPageBreakSelectButtonString();
            return;
        }
        if(style == 8)
        {
            webInfoStr = getPageBreakInfoString();
            webLinkStr = getPageBreakIcoString();
            return;
        } else
        {
            return;
        }
    }

    private String getPageBreakLinkString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("\n<SCRIPT language=javascript>\n");
        sb.append("<!--\n");
        sb.append("function movepage(pageno){\n");
        sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").action=\"").toString());
        sb.append((new StringBuilder(String.valueOf(pageLink))).append("page=\"+pageno+\"&t=").append(totals).append("\";\n").toString());
        sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").submit();\n").toString());
        sb.append("}\n");
        sb.append("-->\n");
        sb.append("</SCRIPT>\n");
        String enableFlag = cpage <= 1 ? "style='display:none'" : "";
        sb.append((new StringBuilder("<a ")).append(enableFlag).append(" ").append(formScript(1)).append(">").toString());
        sb.append(pagesign[0]);
        sb.append((new StringBuilder("</a> <a ")).append(enableFlag).append(" ").append(formScript(cpage - 1)).append(">").toString());
        sb.append(pagesign[1]);
        sb.append("</a> ");
        enableFlag = cpage >= allpage ? "style='display:none'" : "";
        sb.append((new StringBuilder("<a ")).append(enableFlag).append(" ").append(formScript(cpage + 1)).append(">").toString());
        sb.append(pagesign[2]);
        sb.append((new StringBuilder("</a> <a ")).append(enableFlag).append(" ").append(formScript(allpage)).append(">").toString());
        sb.append(pagesign[3]);
        sb.append("</a> ");
        return sb.toString();
    }

    private String getPageBreakButtonString()
    {
        StringBuffer sb = new StringBuffer();
        String enableFlag = cpage <= 1 ? "style='display:none'" : "";
        sb.append((new StringBuilder("<INPUT style=\"")).append(buttonStyle).append("\" ").append(enableFlag).toString());
        sb.append(" onclick=\"movePage('first')\" type=button value=\"");
        sb.append((new StringBuilder(String.valueOf(pagesign[0]))).append("\" name=first> ").toString());
        sb.append((new StringBuilder("<INPUT style=\"")).append(buttonStyle).append("\" ").append(enableFlag).append(" onclick=\"movePage('prev')\" type=button value=\"").append(pagesign[1]).append("\" name=prev> ").toString());
        enableFlag = cpage >= allpage ? "style='display:none'" : "";
        sb.append((new StringBuilder("<INPUT style=\"")).append(buttonStyle).append("\" ").append(enableFlag).append(" onclick=\"movePage('next')\" type=button value=\"").append(pagesign[2]).append("\" name=next> ").toString());
        sb.append((new StringBuilder("<INPUT style=\"")).append(buttonStyle).append("\" ").append(enableFlag).append(" onclick=\"movePage('last')\" type=button value=\"").append(pagesign[3]).append("\" name=last> ").toString());
        sb.append("\n<SCRIPT language=javascript>\n");
        sb.append("<!--\n");
        sb.append((new StringBuilder("var currActionsUrl=\"")).append(pageLink).append("\";\n").toString());
        sb.append("function movePage(page){\n");
        sb.append("var pageno=1;\n");
        sb.append((new StringBuilder("var CurrentPage =")).append(cpage).append(";\n").toString());
        sb.append((new StringBuilder("var TotalPages=")).append(allpage).append(";\n").toString());
        sb.append("if(page==\"first\"){\n");
        sb.append("pageno=1;\n");
        sb.append("}else if(page==\"last\"){\n");
        sb.append("pageno=TotalPages;\n");
        sb.append("}else if(page==\"prev\"){\n");
        sb.append("pageno=CurrentPage-1;\n");
        sb.append("if(pageno<1)pageno=1;\n");
        sb.append("}else if(page==\"next\"){\n");
        sb.append("pageno=CurrentPage+1;\n");
        sb.append("if(pageno>TotalPages)pageno=TotalPages;\n");
        sb.append("}\n");
        if(formName == null || formName.trim().equals(""))
        {
            sb.append((new StringBuilder("location.href=\"")).append(pageLink).append("page=\"+pageno+\"&t=").append(totals).append("\";\n").toString());
        } else
        {
            sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").action=\"").append(pageLink).append("page=\"+pageno+\"&t=").append(totals).append("\";\n").toString());
            sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").submit();").toString());
        }
        sb.append("}\n");
        sb.append("-->\n");
        sb.append("</SCRIPT>\n");
        return sb.toString();
    }

    private String getPageBreakInfoString()
    {
        int _cpage = 0;
        if(allpage == 0)
            _cpage = 0;
        else
            _cpage = cpage;
        StringBuffer sb = new StringBuffer();
        sb.append((new StringBuilder("\u5171")).append(String.valueOf(totals)).append("\u6761\u8BB0\u5F55").toString());
        sb.append((new StringBuilder("\uFF0C\u7B2C")).append(String.valueOf(_cpage)).append("/").append(String.valueOf(allpage)).append("\u9875").toString());
        return sb.toString();
    }

    private String getPageBreakJumpButtonString()
    {
        StringBuffer sb = new StringBuffer();
        String enableFlag = allpage <= 1 ? "style='display:none'" : "";
        sb.append((new StringBuilder("<INPUT style=\"")).append(buttonStyle).append("\" ").append(enableFlag).append(" type=button value=\u8F6C\u81F3 onclick=\"goPage(document.all('_goto').value)\">").toString());
        sb.append((new StringBuilder("<INPUT style=\"")).append(inputStyle).append("\" ").append(enableFlag).append(" onkeydown=\"returnPage(this);\" type=text size=2 name=_goto>").toString());
        sb.append("\n<script>\n");
        sb.append("<!--\n");
        sb.append("function goPage(page){\n");
        sb.append("pageno = parseInt(page,10);\n");
        sb.append("if(isNaN(pageno)){\n");
        sb.append("alert(\"\u60A8\u8981\u8F6C\u81F3\u7684\u9875\u9762\u4E0D\u80FD\u4E3A\u7A7A\u4E14\u5FC5\u987B\u4E3A\u6570\u5B57\uFF01\");\n");
        sb.append("document.all(\"_goto\").value=\"\";\n");
        sb.append("document.all(\"_goto\").style.background=\"#ddd\";\n");
        sb.append("document.all(\"_goto\").focus();\n");
        sb.append("return false;\n");
        sb.append("}\n");
        sb.append((new StringBuilder("var TotalPages=")).append(allpage).append(";\n").toString());
        sb.append("if(pageno>TotalPages || pageno<1){\n");
        sb.append("alert(\"\u60A8\u8981\u8F6C\u81F3\u7684\u9875\u9762\u8D85\u51FA\u4E86\u8303\u56F4\uFF01\");\n");
        sb.append("document.all(\"_goto\").value=\"\";\n");
        sb.append("document.all(\"_goto\").style.background=\"#ddd\";\n");
        sb.append("document.all(\"_goto\").focus();\n");
        sb.append("return false;\n");
        sb.append("}\n");
        if(formName == null || formName.trim().equals(""))
        {
            sb.append((new StringBuilder("location=\"")).append(pageLink).toString());
            sb.append((new StringBuilder("page=\"+pageno+\"&t=")).append(totals).append("\";\n}\n").toString());
        } else
        {
            sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").action=\"").toString());
            sb.append((new StringBuilder(String.valueOf(pageLink))).append("page=\"+pageno+\"&t=").append(totals).append("\";").toString());
            sb.append((new StringBuilder("\ndocument.all(\"")).append(formName).append("\").submit();}\n").toString());
        }
        sb.append("function returnPage(el) {\n");
        sb.append("document.all(\"_goto\").style.background=\"#fff\";\n");
        sb.append("if(window.event.keyCode==13) {\n");
        sb.append("goPage(el.value);\n");
        sb.append("return false;\n");
        sb.append("}}\n");
        sb.append("-->\n");
        sb.append("</SCRIPT>\n");
        return sb.toString();
    }

    private String getPageBreakSelectButtonString()
    {
        StringBuffer sb = new StringBuffer();
        String enableFlag = allpage <= 1 ? "style='display:none'" : "";
        sb.append((new StringBuilder("<select name=\"p_select\" ")).append(enableFlag).append(" style=\"").append(inputStyle).append("\" onChange=\"goPage(this.value);\">\n").toString());
        for(int i = 1; i <= allpage; i++)
        {
            String selected = page != i ? "" : "selected";
            sb.append((new StringBuilder("<option value=")).append(i).append(" ").append(selected).append(">").append(i).append("</option>\n").toString());
        }

        sb.append("</select>\n");
        sb.append("\n<script>\n");
        sb.append("<!--\n");
        sb.append("function goPage(page){\n");
        sb.append("pageno = parseInt(page,10);\n");
        if(formName == null || formName.trim().equals(""))
        {
            sb.append((new StringBuilder("location=\"")).append(pageLink).toString());
            sb.append((new StringBuilder("page=\"+pageno+\"&t=")).append(totals).append("\";\n}\n").toString());
        } else
        {
            sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").action=\"").toString());
            sb.append((new StringBuilder(String.valueOf(pageLink))).append("page=\"+pageno+\"&t=").append(totals).append("\";").toString());
            sb.append((new StringBuilder("\ndocument.all(\"")).append(formName).append("\").submit();}\n").toString());
        }
        sb.append("-->\n");
        sb.append("</SCRIPT>\n");
        return sb.toString();
    }

    private String getPageBreakIcoString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("\n<SCRIPT language=javascript>\n");
        sb.append("<!--\n");
        sb.append("function movepage(pageno){\n");
        sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").action=\"").toString());
        sb.append((new StringBuilder(String.valueOf(pageLink))).append("page=\"+pageno+\"&t=").append(totals).append("\";\n").toString());
        sb.append((new StringBuilder("document.all(\"")).append(formName).append("\").submit();\n").toString());
        sb.append("}\n");
        sb.append("-->\n");
        sb.append("</SCRIPT>\n");
        int cp = cpage <= 1 ? 1 : cpage - 1;
        if(cpage != 1)
            sb.append((new StringBuilder("<a ")).append(formScript(1)).append(">").toString());
        sb.append("<img border=0 src=\"images/arrow_first.gif\">");
        if(cpage != 1)
            sb.append("</a>");
        sb.append((new StringBuilder("&nbsp;<a  ")).append(formScript(cp)).append(">").toString());
        sb.append("<img border=0 src=\"images/arrow_previous.gif\" >");
        sb.append("</a> ");
        sb.append((new StringBuilder(String.valueOf(cpage))).append("/").append(allpage).toString());
        cp = cpage >= allpage ? allpage : cpage + 1;
        sb.append((new StringBuilder(" <a  ")).append(formScript(cp)).append(">").toString());
        sb.append("<img border=0 src=\"images/arrow_next.gif\" >");
        sb.append("</a>&nbsp;");
        if(cpage != allpage)
            sb.append((new StringBuilder("<a  ")).append(formScript(allpage)).append(">").toString());
        sb.append("<img border=0 src=\"images/arrow_last.gif\" >");
        if(cpage != allpage)
            sb.append("</a> ");
        return sb.toString();
    }

    private String formScript(int pageno)
    {
        String astr = "";
        if(formName == null || formName.trim().equals(""))
            astr = (new StringBuilder("href='")).append(pageLink).append("page=").append(pageno).append("&t=").append(totals).append("'").toString();
        else
            astr = (new StringBuilder("href='#' onclick='movepage(")).append(pageno).append(")'").toString();
        return astr;
    }

    private HttpServletRequest request;
    private String pageLink;
    private int page;
    private int totals;
    private int perpagenum;
    private int style;
    private int allpage;
    private int cpage;
    private int srecords;
    private String webLinkStr;
    private String webJumpStr;
    private String webInfoStr;
    private String webScriptStr;
    private String pagesign[] = {
        "\u9996\u9875", "\u4E0A\u4E00\u9875", "\u4E0B\u4E00\u9875", "\u672B\u9875"
    };
    private String buttonStyle;
    private String inputStyle;
    private String formName;
    public static final int SYTLE_LINK = 0;
    public static final int SYTLE_LINK_INFO = 1;
    public static final int SYTLE_LINK_INFO_JUMP = 2;
    public static final int SYTLE_LINK_INFO_SELECT = 3;
    public static final int SYTLE_BUTTON = 4;
    public static final int SYTLE_BUTTON_INFO = 5;
    public static final int SYTLE_BUTTON_INFO_JUMP = 6;
    public static final int SYTLE_BUTTON_INFO_SELECT = 7;
    public static final int SYTLE_ICO_LINK = 8;
}