<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>partList</title>
</head>
<body>
<h1>stockList</h1>
<table>
    <tr><th>ID</th><th>NAME</th><th>CODE</th></tr>
<#list stoks as stock>
    <tr>
        <td>${stock.getStockId()}</td>
        <td>${stock.getStockName()}</td>
        <td>${stock.getStockCode()}</td>
    </tr>
</#list>
</table>
</body>
</html>