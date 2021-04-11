<%-- 
    Document   : demnguoc
    Created on : 31-Jan-2021, 12:16:23
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đồng hồ đếm ngược bằng JS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
       
    </head>
    <body>
       
      <style>
            span1{border: solid 1px #ACACAC; padding: 2px; size:12px ;color: mediumvioletred}
        </style>
        <script language="javascript">

            var h = null; // Giờ
            var m = null; // Phút
            var s = null; // Giây

            var timeout = null; // Timeout

            function start()
            {
                /*BƯỚC 1: LẤY GIÁ TRỊ BAN ĐẦU*/
                if (h === null)
                {
                    h = parseInt(document.getElementById('h_val').value);
                    m = parseInt(document.getElementById('m_val').value);
                    s = parseInt(document.getElementById('s_val').value);
                }

                /*BƯỚC 1: CHUYỂN ĐỔI DỮ LIỆU*/
                // Nếu số giây = -1 tức là đã chạy ngược hết số giây, lúc này:
                //  - giảm số phút xuống 1 đơn vị
                //  - thiết lập số giây lại 59
                if (s === -1) {
                    m -= 1;
                    s = 59;
                }

                // Nếu số phút = -1 tức là đã chạy ngược hết số phút, lúc này:
                //  - giảm số giờ xuống 1 đơn vị
                //  - thiết lập số phút lại 59
                if (m === -1) {
                    h -= 1;
                    m = 59;
                }

                // Nếu số giờ = -1 tức là đã hết giờ, lúc này:
                //  - Dừng chương trình
                if (h == -1) {
                    clearTimeout(timeout);
                    alert('TimeOut');
                    return false;
                }

                /*BƯỚC 1: HIỂN THỊ ĐỒNG HỒ*/
                document.getElementById('h').innerText = h.toString();
                document.getElementById('m').innerText = m.toString();
                document.getElementById('s').innerText = s.toString();

                /*BƯỚC 1: GIẢM PHÚT XUỐNG 1 GIÂY VÀ GỌI LẠI SAU 1 GIÂY */
                timeout = setTimeout(function () {
                    s--;
                    start();
                }, 1000);
            }

            function stop() {
                clearTimeout(timeout);
            }


        </script>

      
                <div >
                    <input type="hidden" id="h_val" placeholder="Giờ" value="0"/> <br/>
                    <input type="hidden" id="m_val" placeholder="Phút" value="1"/> <br/>
                    <input type="hidden" id="s_val" placeholder="Giây" value="0"/>
                </div>


                    <div class=" pull-right  col-xl-2"> <strong>
                            <span1 id="h">0</span1> :
                            <span1 id="m">0</span1> :
                            <span1 id="s">0</span1><br/>
                            <input type="submit" value="Start" onclick ="start()"/>
                            <input type="submit" value="Stop" onclick="stop()"/> 
                        </strong>
                    </div> 
    </body>
</html>
