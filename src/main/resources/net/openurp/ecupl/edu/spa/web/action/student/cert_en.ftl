[#ftl/]
[#setting locale="en_US"]

[#-- adjectival possessive pronoun--]
[#function getApp gender]
 [#if gender??]
   [#if gender.id==2][#return "her"/][#else][#return "his"/][/#if]
 [#else]
   [#return "his"/]
 [/#if]
[/#function]

[#function getMajor std]
  [#if (std.state.direction.enName)??]
    [#return ((std.state.major.enName)!'__')+ "(" + std.state.direction.enName +")" /]
  [#else]
    [#return (std.state.major.enName)!(std.state.major.name) /]
  [/#if]
[/#function]

[#if grade=4 || grade > 4]
<p ALIGN="left" style="margin-top:10px;FONT-SIZE:14pt;line-height:140%;letter-spacing:1px;">
This is to certify that ${(std.person.phoneticName)!"__"} is a registered full time student of th[#t/]
e School of ${(std.state.department.enName)!("___")} of this university. This student has completed nearl[#t/]
y all the courses in ${getMajor(std)} and, in line with regulations by the Ministry of Education[#t/]
, is to be awarded a diploma of graduation in ${std.graduateOn?string("MMMMM, yyyy")} upon completion [#t/]
 of ${getApp(std.person.gender)} graduation thesis. This student is working on the courses of ${getApp(std.person.gender)} last year of study and[#t/]
, in line with the degree regulations of this university[#t/]
, is to be awarded a degree of ${(std.program.degree.enName)!"__"} upon completion of all the courses req[#t/]
uired with GPA of compulsory courses above 2.0 points.
</p>
[#else]
<p ALIGN="left" style="margin-top:10px;FONT-SIZE:15pt;line-height:230%;letter-spacing:1px;">
[#assign gradeNameMap={'1':'first','2':'second','3':'third','4':'fourth'}/]
This is to certify that ${(std.person.phoneticName)!"__"}, ${(std.person.gender.enName)!"__"}[#t]
, born on ${(std.person.birthday?string('dd MMMMM,yyyy'))!"_______"}, is a registered full time studen[#t]
t of School of ${(std.state.department.enName)!("___")} of this university from ${std.beginOn?string('dd MMMMM,yyyy')}[#t]
. This student is majoring in ${getMajor(std)} , and now is ${getApp(std.person.gender)} ${gradeNameMap[grade?string]} year of ${std.duration} Years program length.
</p>
[/#if]