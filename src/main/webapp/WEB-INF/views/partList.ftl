<#assign title="partList">
<#include "inc/header.inc">

<#assign countPC = 0>

<#include "inc/partFilter.ftl">
<div class="addPart"><a href="/part/add/">Добавить комплектующее</a></div>
<#if partList?size &gt; 0>
    <table class="partList">
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Required</th>
            <th>Count</th>
            <th>Actions</th>
        </tr>
    <#list partList as part>
        <#if part.getRequired() && (countPC == 0 || part.getCount() < countPC)>
            <#assign countPC = part.getCount()>
        </#if>
        <tr>
            <td>${part.getPartId()}</td>
            <td>${part.getDescriptionRu()}</td>
            <td>${part.getRequired()?string('Да', 'Нет')}</td>
            <td>${part.getCount()}</td>
            <td>
                <a href="/part/edit/${part.getPartId()}">Изменить</a><br/>
                <a href="/part/delete/${part.getPartId()}">Удалить</a><br/>
            </td>
        </tr>
    </#list>
        <tr><td colspan="4"><b>Можно собрать ПК:</b></td><td>${countPC}</td></tr>
    </table>
<#else>
<div class="error">Список пуст</div>
</#if>

<#include "inc/pager.ftl">

<#include "inc/footer.inc">