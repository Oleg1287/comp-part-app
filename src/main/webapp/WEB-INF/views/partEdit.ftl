<#assign title="partEdit">
<#include "inc/header.inc">

<form action="/part/edit" method="post">
    <input type="hidden" name="partId" value="${part.getPartId()}">
    <table class="partEdit">
        <tr>
            <td>ID</td>
            <td>${part.getPartId()}</td>
        </tr>
        <tr>
            <td>Описание по русски</td>
            <td><textarea name="descriptionRu">${part.getDescriptionRu()}</textarea></td>
        </tr>
        <tr>
            <td>Компонент обязателен</td>
            <td>
                <select name="required">
                    <option value="true">Да</option>
                    <option value="false"${part.getRequired()?string('', ' selected="selected"')}>Нет</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>Количество на складе</td>
            <td><input type="text" name="count" value="${part.getCount()}"></td>
        </tr>

        <tr><td colspan="2">
            <button type="submit">Сохранить</button>
        </td></tr>
    </table>
</form>

<#include "inc/a_href_part_list.inc">
<#include "inc/footer.inc">