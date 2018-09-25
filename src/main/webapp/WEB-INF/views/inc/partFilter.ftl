<#list RequestParameters as key, val>
    <#assign params = params!"" + key + "=" + val + "&">
</#list>

<#assign url = springMacroRequestContext.getRequestUri()>
<form method="get" action="${url?replace("/page/\\d+", "/page/1", "r")}">
<table>
    <tr><td>Description</td><td>
        <input type="text" name="description_ru" value="${RequestParameters.description_ru!""}">
    </td></tr>
    <tr><td>Required</td><td>
        <#assign required = RequestParameters.required!"">

        <input type="radio" name="required" value=""    ${(required == ""   )?string("checked='checked'", "")}>Не имеет значения<br/>
        <input type="radio" name="required" value="yes" ${(required == "yes")?string("checked='checked'", "")}>Да<br/>
        <input type="radio" name="required" value="no"  ${(required == "no" )?string("checked='checked'", "")}>Нет
    </td></tr>
    <tr><td colspan=2" align="right"><button type="submit">Найти</button> </td></tr>
</table>
</form>
