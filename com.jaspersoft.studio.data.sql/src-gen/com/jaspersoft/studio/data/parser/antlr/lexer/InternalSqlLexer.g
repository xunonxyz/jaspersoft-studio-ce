
/*
* generated by Xtext
*/
lexer grammar InternalSqlLexer;


@header {
package com.jaspersoft.studio.data.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




KEYWORD_104 : ('U'|'u')('N'|'n')('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d')('E'|'e')('D'|'d')' '('F'|'f')('O'|'o')('L'|'l')('L'|'l')('O'|'o')('W'|'w')('I'|'i')('N'|'n')('G'|'g');

KEYWORD_105 : ('U'|'u')('N'|'n')('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d')('E'|'e')('D'|'d')' '('P'|'p')('R'|'r')('E'|'e')('C'|'c')('E'|'e')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

KEYWORD_103 : ('O'|'o')('R'|'r')('D'|'d')('E'|'e')('R'|'r')' '('S'|'s')('I'|'i')('B'|'b')('L'|'l')('I'|'i')('N'|'n')('G'|'g')('S'|'s')' '('B'|'b')('Y'|'y');

KEYWORD_102 : ('S'|'s')('T'|'t')('R'|'r')('A'|'a')('I'|'i')('G'|'g')('H'|'h')('T'|'t')'_'('J'|'j')('O'|'o')('I'|'i')('N'|'n');

KEYWORD_101 : ('P'|'p')('A'|'a')('R'|'r')('T'|'t')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n')' '('B'|'b')('Y'|'y');

KEYWORD_97 : ('C'|'c')('U'|'u')('R'|'r')('R'|'r')('E'|'e')('N'|'n')('T'|'t')' '('R'|'r')('O'|'o')('W'|'w');

KEYWORD_98 : ('F'|'f')('E'|'e')('T'|'t')('C'|'c')('H'|'h')' '('F'|'f')('I'|'i')('R'|'r')('S'|'s')('T'|'t');

KEYWORD_99 : ('I'|'i')('S'|'s')' '('N'|'n')('O'|'o')('T'|'t')' '('N'|'n')('U'|'u')('L'|'l')('L'|'l');

KEYWORD_100 : ('N'|'n')('O'|'o')('T'|'t')' '('B'|'b')('E'|'e')('T'|'t')('W'|'w')('E'|'e')('E'|'e')('N'|'n');

KEYWORD_96 : ('N'|'n')('O'|'o')('T'|'t')' '('E'|'e')('X'|'x')('I'|'i')('S'|'s')('T'|'t')('S'|'s');

KEYWORD_91 : ('F'|'f')('O'|'o')('L'|'l')('L'|'l')('O'|'o')('W'|'w')('I'|'i')('N'|'n')('G'|'g');

KEYWORD_92 : ('I'|'i')('N'|'n')('T'|'t')('E'|'e')('R'|'r')('S'|'s')('E'|'e')('C'|'c')('T'|'t');

KEYWORD_93 : ('P'|'p')('R'|'r')('E'|'e')('C'|'c')('E'|'e')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

KEYWORD_94 : ('W'|'w')('I'|'i')('T'|'t')('H'|'h')' '('T'|'t')('I'|'i')('E'|'e')('S'|'s');

KEYWORD_95 : '['('B'|'b')('E'|'e')('T'|'t')('W'|'w')('E'|'e')('E'|'e')('N'|'n')']';

KEYWORD_83 : ('B'|'b')('E'|'e')('T'|'t')('W'|'w')('E'|'e')('E'|'e')('N'|'n')']';

KEYWORD_84 : ('D'|'d')('I'|'i')('S'|'s')('T'|'t')('I'|'i')('N'|'n')('C'|'c')('T'|'t');

KEYWORD_85 : ('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p')' '('B'|'b')('Y'|'y');

KEYWORD_86 : ('N'|'n')('O'|'o')('T'|'t')' '('L'|'l')('I'|'i')('K'|'k')('E'|'e');

KEYWORD_87 : ('N'|'n')('O'|'o')('T'|'t')('E'|'e')('Q'|'q')('U'|'u')('A'|'a')('L'|'l');

KEYWORD_88 : ('O'|'o')('R'|'r')('D'|'d')('E'|'e')('R'|'r')' '('B'|'b')('Y'|'y');

KEYWORD_89 : '['('B'|'b')('E'|'e')('T'|'t')('W'|'w')('E'|'e')('E'|'e')('N'|'n');

KEYWORD_90 : '['('G'|'g')('R'|'r')('E'|'e')('A'|'a')('T'|'t')('E'|'e')('R'|'r');

KEYWORD_75 : ('B'|'b')('E'|'e')('T'|'t')('W'|'w')('E'|'e')('E'|'e')('N'|'n');

KEYWORD_76 : ('E'|'e')('X'|'x')('C'|'c')('L'|'l')('U'|'u')('D'|'d')('E'|'e');

KEYWORD_77 : ('G'|'g')('R'|'r')('E'|'e')('A'|'a')('T'|'t')('E'|'e')('R'|'r');

KEYWORD_78 : ('I'|'i')('N'|'n')('C'|'c')('L'|'l')('U'|'u')('D'|'d')('E'|'e');

KEYWORD_79 : ('I'|'i')('S'|'s')' '('N'|'n')('U'|'u')('L'|'l')('L'|'l');

KEYWORD_80 : ('N'|'n')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('A'|'a')('L'|'l');

KEYWORD_81 : ('P'|'p')('E'|'e')('R'|'r')('C'|'c')('E'|'e')('N'|'n')('T'|'t');

KEYWORD_82 : ('U'|'u')('N'|'n')('P'|'p')('I'|'i')('V'|'v')('O'|'o')('T'|'t');

KEYWORD_69 : ('E'|'e')('X'|'x')('C'|'c')('E'|'e')('P'|'p')('T'|'t');

KEYWORD_70 : ('E'|'e')('X'|'x')('I'|'i')('S'|'s')('T'|'t')('S'|'s');

KEYWORD_71 : ('H'|'h')('A'|'a')('V'|'v')('I'|'i')('N'|'n')('G'|'g');

KEYWORD_72 : ('N'|'n')('O'|'o')('T'|'t')' '('I'|'i')('N'|'n');

KEYWORD_73 : ('O'|'o')('F'|'f')('F'|'f')('S'|'s')('E'|'e')('T'|'t');

KEYWORD_74 : ('S'|'s')('E'|'e')('L'|'l')('E'|'e')('C'|'c')('T'|'t');

KEYWORD_53 : ('C'|'c')('A'|'a')('S'|'s')('T'|'t')'(';

KEYWORD_54 : ('C'|'c')('R'|'r')('O'|'o')('S'|'s')('S'|'s');

KEYWORD_55 : ('E'|'e')('Q'|'q')('U'|'u')('A'|'a')('L'|'l');

KEYWORD_56 : ('F'|'f')('I'|'i')('R'|'r')('S'|'s')('T'|'t');

KEYWORD_57 : ('I'|'i')('N'|'n')('N'|'n')('E'|'e')('R'|'r');

KEYWORD_58 : ('L'|'l')('E'|'e')('S'|'s')('S'|'s')']';

KEYWORD_59 : ('L'|'l')('I'|'i')('M'|'m')('I'|'i')('T'|'t');

KEYWORD_60 : ('M'|'m')('I'|'i')('N'|'n')('U'|'u')('S'|'s');

KEYWORD_61 : ('N'|'n')('O'|'o')('T'|'t')('I'|'i')('N'|'n');

KEYWORD_62 : ('N'|'n')('U'|'u')('L'|'l')('L'|'l')('S'|'s');

KEYWORD_63 : ('O'|'o')('U'|'u')('T'|'t')('E'|'e')('R'|'r');

KEYWORD_64 : ('P'|'p')('I'|'i')('V'|'v')('O'|'o')('T'|'t');

KEYWORD_65 : ('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e');

KEYWORD_66 : ('R'|'r')('I'|'i')('G'|'g')('H'|'h')('T'|'t');

KEYWORD_67 : ('U'|'u')('N'|'n')('I'|'i')('O'|'o')('N'|'n');

KEYWORD_68 : ('W'|'w')('H'|'h')('E'|'e')('R'|'r')('E'|'e');

KEYWORD_35 : ('C'|'c')('A'|'a')('S'|'s')('E'|'e');

KEYWORD_36 : ('D'|'d')('E'|'e')('S'|'s')('C'|'c');

KEYWORD_37 : ('E'|'e')('L'|'l')('S'|'s')('E'|'e');

KEYWORD_38 : ('F'|'f')('R'|'r')('O'|'o')('M'|'m');

KEYWORD_39 : ('F'|'f')('U'|'u')('L'|'l')('L'|'l');

KEYWORD_40 : ('J'|'j')('O'|'o')('I'|'i')('N'|'n');

KEYWORD_41 : ('L'|'l')('A'|'a')('S'|'s')('T'|'t');

KEYWORD_42 : ('L'|'l')('E'|'e')('F'|'f')('T'|'t');

KEYWORD_43 : ('L'|'l')('E'|'e')('S'|'s')('S'|'s');

KEYWORD_44 : ('L'|'l')('I'|'i')('K'|'k')('E'|'e');

KEYWORD_45 : ('N'|'n')('O'|'o')('T'|'t')'\n';

KEYWORD_46 : ('N'|'n')('O'|'o')('T'|'t')' ';

KEYWORD_47 : ('O'|'o')('N'|'n')('L'|'l')('Y'|'y');

KEYWORD_48 : ('O'|'o')('V'|'v')('E'|'e')('R'|'r');

KEYWORD_49 : ('R'|'r')('O'|'o')('W'|'w')('S'|'s');

KEYWORD_50 : ('S'|'s')('O'|'o')('M'|'m')('E'|'e');

KEYWORD_51 : ('T'|'t')('H'|'h')('E'|'e')('N'|'n');

KEYWORD_52 : ('W'|'w')('H'|'h')('E'|'e')('N'|'n');

KEYWORD_25 : '(''+'')';

KEYWORD_26 : ('A'|'a')('L'|'l')('L'|'l');

KEYWORD_27 : ('A'|'a')('N'|'n')('D'|'d');

KEYWORD_28 : ('A'|'a')('N'|'n')('Y'|'y');

KEYWORD_29 : ('A'|'a')('S'|'s')('C'|'c');

KEYWORD_30 : ('E'|'e')('N'|'n')('D'|'d');

KEYWORD_31 : ('F'|'f')('O'|'o')('R'|'r');

KEYWORD_32 : ('R'|'r')('O'|'o')('W'|'w');

KEYWORD_33 : ('T'|'t')('O'|'o')('P'|'p');

KEYWORD_34 : ('X'|'x')('M'|'m')('L'|'l');

KEYWORD_14 : '!''=';

KEYWORD_15 : '$'('X'|'x');

KEYWORD_16 : '<''=';

KEYWORD_17 : '<''>';

KEYWORD_18 : '>''=';

KEYWORD_19 : ('A'|'a')('S'|'s');

KEYWORD_20 : ('I'|'i')('N'|'n');

KEYWORD_21 : ('O'|'o')('N'|'n');

KEYWORD_22 : ('O'|'o')('R'|'r');

KEYWORD_23 : '^''=';

KEYWORD_24 : '|''|';

KEYWORD_1 : '(';

KEYWORD_2 : ')';

KEYWORD_3 : '+';

KEYWORD_4 : ',';

KEYWORD_5 : '-';

KEYWORD_6 : '.';

KEYWORD_7 : '/';

KEYWORD_8 : '<';

KEYWORD_9 : '=';

KEYWORD_10 : '>';

KEYWORD_11 : '{';

KEYWORD_12 : '|';

KEYWORD_13 : '}';



RULE_JRPARAM : '$P{' ( options {greedy=false;} : . )*'}';

RULE_JRNPARAM : '$P!{' ( options {greedy=false;} : . )*'}';

RULE_STAR : '*';

RULE_INT : '-'? ('0'..'9')+;

RULE_TIMESTAMP : RULE_DATE ' ' RULE_TIME;

RULE_DATE : '\'' '0'..'9' '0'..'9' '0'..'9' '0'..'9' '-' '0'..'1' '0'..'9' '-' '0'..'3' '0'..'9' '\'';

RULE_TIME : '\'' '0'..'9' '0'..'9' ':' '0'..'9' '0'..'9' ':' '0'..'1' '0'..'9' '.' '0'..'9' '0'..'9' '0'..'9' '\'';

RULE_SIGNED_DOUBLE : '-'? ('0'..'9')+ ('.' ('0'..'9')+)?;

RULE_STRING_ : '\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'';

RULE_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

RULE_DBNAME : ('`' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'`')))* '`'|'[' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|']')))* ']');

RULE_ID : ('a'..'z'|'A'..'Z'|'\u00C0'..'\u00FF'|'\u0100'..'\u017F'|'\u0180'..'\u024F'|'\u0410'..'\u044F'|'_'|'-'|'\u3041'..'\u309F'|'\u30A0'..'\u30FF'|'\u31F0'..'\u31FF'|'\u4E00'..'\u9FFF'|'\u6B74'..'\u3059'|'\u30A2'..'\u30F3'|'\uF900'..'\uFAFF'|'\u3400'..'\u4DBF'|'\uFF3F'|'0'..'9')*;

RULE_SL_COMMENT : ('--'|'#'|'//') ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



