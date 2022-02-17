[#ftl]
[#if grade=4 || grade > 4]
<p ALIGN="left" style="margin-top:10px;font-size:15pt;line-height:65px;letter-spacing:1px;">
${std.user.name}同学系${std.project.school.name}&nbsp;&nbsp;${std.state.department.name}&nbsp;&nbsp;学院四年级全日制本科生，在校学习期间已基本修完&nbsp;&nbsp;
${std.state.major.name}[#if std.state.direction??](${std.state.direction.name})[/#if]&nbsp;&nbsp;专业课程。根据国家教育部有关规定，将在完成毕业论文后于${(std.state.grade[0..3]?number)+4}年7月毕业。现该生正在修读最后一个学年的课程，一旦学分修满，课程考核成绩平均学分绩点达到2.0以上，符合《华东政法大学授予本科毕业生学士学位实施细则》的有关规定，可授予${(program.degree.name)!"__"}学位。
</p>
[#else]
<p ALIGN="left" style="margin-top:10px;font-size:15pt;line-height:65px;letter-spacing:1px;">
[#assign gradeNameMap={'1':'一','2':'二','3':'三','4':'四','5':'四'}/]
${std.user.name}同学，性别${(std.person.gender.name)!}，[#t/]
[#if std.person.birthday??]${std.person.birthday?string('yyyy年MM月dd日')}[#else]&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日[/#if]
出生。于${std.beginOn?string("yyyy年MM月dd日")}起就读我校&nbsp;${std.state.department.name}&nbsp;[#t/]
${(std.state.major.name)!}&nbsp;专业，学制${std.duration}年，现为[#if std.level.name?contains("专升本")]专科起点本科[#else]本科[/#if]${gradeNameMap[grade?string]}年级在读学生。
</p>
[/#if]
