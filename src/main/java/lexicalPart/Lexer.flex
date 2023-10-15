package lexicalPart;
import static lexicalPart.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
    int linea = 1;
    public int posicion = 0;
%}
%%

\n {linea = linea+1;}


as |
assert |
break |
class |
continue |
def |
del |
elif |
else |
except |
finally |
for |
from|
global |
if |
import |
in |
is |
lambda |
None |
nonlocal |
pass |
raise |
return |
try |
while |
with |
yield |
print {posicion = linea; lexeme=yytext(); return PalabrasClave;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

"-" |
"**" |
"/" |
"//" |
"%" |
"*" |
"+" {posicion = linea; lexeme =yytext(); return Aritmeticos;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

"&" |
"|" |
"^" |
"<<" |
">>" {posicion = linea; lexeme =yytext(); return Bits;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

"==" |
"!=" |
">" |
"<" |
">=" |
"<=" {posicion = linea; lexeme =yytext(); return Comparacion;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

and |
or |
not {posicion = linea; lexeme =yytext(); return Logicos;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

"=" {posicion = linea; lexeme =yytext(); return Asignacion;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

\"[^\"]*\" |
\'[^\']*\' {posicion = linea; lexeme =yytext(); return Cadena;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

True |
False {posicion = linea; lexeme =yytext(); return Booleanas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

\#[^\#]*\#  {posicion = linea; lexeme =yytext(); return Comentario;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

"(" | 
")" |
"{" |
"}" |
"[" |
"]" |
"," |
";" |
":" {posicion = linea; lexeme =yytext(); return Otros;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

{L}({L}|{D})* {posicion = linea; lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {posicion = linea; lexeme=yytext(); return NumeroEntero;}
[0-9]+("."[0-9]+) {posicion = linea; lexeme=yytext(); return NumeroDecimal;} 
. {return ERROR;}
