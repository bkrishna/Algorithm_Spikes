<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output encoding="UTF-8" method="html" indent="yes" doctype-public="-//W3C//DTD HTML 4.01Transitional//EN" doctype-system="http://www.w3.org/TR/html4/loose.dtd"/>

	<xsl:template match="/">
		<html>
			<body>
				<h2>List of Odd and Even Numbers</h2>
				<a href="/listNumbersApp/getGeneratedXml.jsp">Download the generated XML File</a><br/>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Odd Number</th>
						<th>Even Number</th>
					</tr>
					<xsl:for-each select="numbers/value">
						<xsl:variable name="numberType" select="normalize-space(type)" />
						<xsl:variable name="currentPos" select="position()" />
						<xsl:choose>
							<xsl:when test="$numberType = 'odd'">
								<xsl:variable name="oddValue" select="normalize-space(number)" />
								<xsl:variable name="evenValue" select="normalize-space(../value[$currentPos + 1]/number)" />
								<tr>
									<td><xsl:value-of select="$oddValue"/></td>
									<td><xsl:value-of select="$evenValue"/></td>
								</tr>
							</xsl:when>
							<xsl:otherwise>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>