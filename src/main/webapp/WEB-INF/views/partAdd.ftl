<#assign title="partEdit">
<#include "inc/header.inc">

<form action="/part/add" method="post">
    <table class="partEdit">
        <tr>
            <td>Описание по русски</td>
            <td><textarea name="descriptionRu"></textarea></td>
        </tr>
        <tr>
            <td>Компонент обязателен</td>
            <td>
                <select name="required">
                    <option value="true">Да</option>
                    <option value="false">Нет</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>Количество на складе</td>
            <td><input type="text" name="count" value="0"></td>
        </tr>

        <tr><td colspan="2">
            <button type="submit">Сохранить</button>
        </td></tr>
    </table>
</form>

<#include "inc/a_href_part_list.inc">
<#include "inc/footer.inc">