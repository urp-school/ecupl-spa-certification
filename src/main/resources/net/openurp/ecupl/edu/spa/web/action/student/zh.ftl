<!DOCTYPE html>
<html lang="zh_CN">
  <head>
    <title></title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="content-style-type" content="text/css"/>
    <meta http-equiv="content-script-type" content="text/javascript"/>
 </head>
 <body style="padding:5mm 10mm 0mm 10mm">
 <div style="width:100%" class="gradePage">
    <TABLE WIDTH="100%" BORDER="0" CELLPADDING="0" CELLSPACING="0">
      <tr>
        <td ALIGN="CENTER">
         <div align='center'><img src="${b.static_url('urp','images/banner_long.png')}" style="height:25.5mm;width:183mm"/></div>
         <div style="padding:0mm 10mm 0mm 10mm;height:722px;text-align:center;">
            <h1 ALIGN="CENTER"><span style="letter-spacing:20px">在读证明</span></h1>
            <p>&nbsp;</p>
            <div style="text-align:left;text-indent:3em;">
                [#include "cert_zh.ftl"/]
                <p ALIGN="left"><span style="font-size:15pt;letter-spacing:5px;float:left;">特此证明</span></p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            </div>
        </div>
        </td>
     </tr>
   </table>

     <div style="float:right">
     <table>
       <tr><td>
         <p style="margin-top:60px"><span style="font-size:15pt;letter-spacing:5px;">${b.now?string('yyyy年MM月dd日')}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>
        <img src="${b.static_url('urp','images/student_sig2.png')}" style="height:42mm;width:42mm;margin-left: 10px;margin-top: -120px;"/>
       </td></tr>
     </table>
     </div>
  </div>
[@b.foot/]
