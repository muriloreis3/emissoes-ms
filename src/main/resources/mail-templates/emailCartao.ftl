<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <th>Olá ${dadosCartao.cliente}</th>
        </thead>
        <tbody>
            <tr>
                <td>
                    Esse é o seu novo cartão
                </td>
            </tr>
            <table>
                <tbody>
                    <tr>
                        <td>
                            numero: ${dadosCartao.numero}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            emissao: ${dadosCartao.emissao}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            vencimento: ${dadosCartao.vencimento}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            cvv: ${dadosCartao.cvv}
                        </td>
                    </tr>
                </tbody>
            </table>
        </tbody>
    </table>
</body>
</html>