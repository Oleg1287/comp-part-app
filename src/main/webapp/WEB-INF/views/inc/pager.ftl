<#assign params = "">

<#list RequestParameters as key, val>
    <#assign params = params + key + "=" + val + "&">
</#list>

<#assign params = (params)?remove_ending("&") >

<#assign lastPage = pager.getCountPage()>
<#if (pager.getCountPage() > 1) >
    <#assign url = springMacroRequestContext.getRequestUri()>
    <#assign url = url + "?" + params >
    <#if pager.getPage() == 1>
        1
    <#else>
        <a href="${url?replace("/page/\\d+", "/page/1", "r")}">1</a>
    </#if>
    <#list 2..lastPage as page>
        |
        <#if page == pager.getPage()>
            ${page}
        <#else>
            <a href="${url?replace("/page/\\d+", "/page/"+page, "r")}">${page}</a>
        </#if>
    </#list>
<br/>Количество записей:<i><b>${pager.getCountRows()}</b></i>
</#if>