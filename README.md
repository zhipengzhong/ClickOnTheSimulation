# ClickOnTheSimulation
通过简单的代码，控制手机的屏幕和物理按键，不只是在某一个APP里去操作，而是整个手机系统。  

#### 效果图
![模拟点击效果图](1.gif)




#### 功能通过**adb shell input**命令来实现，需要root权限，首先看一下input命令：

 - input text <string\>    
 本指令用于模拟输入字符，<string\>指的是模拟输入的内容  
 使用时先点击输入框获取焦点，然后通过adb shell input text 梅花香自苦寒来，就能往EditText中输入梅花香自苦寒来

 - input keyevent <key code number or name\>    
 本指令用于模拟按下按键，<key code number or name\> 指的是Android中按键代码  
 比如Home键 keycode = 3、比如回退键 keycode = 4，使用时adb shell input keyevent 3 就相当于点击了Home键  
 Android的详细keycode：http://blog.csdn.net/huiguixian/article/details/8550170
 
 - input tap <x\> <y\>  
 本指令用于模拟点击，X、Y坐标使用的是屏幕的真实坐标， <x\>指的是点击的X坐标 <y\>指的是点击的Y坐标  
 使用时通过adb shell input tap 200 200即可模拟点击屏幕中坐标200，200 的位置

 - input swipe <x1\> <y1\> <x2\> <y2\> [duration(ms)]  
 本指令用于模拟滑动，<x1\>起始点的X轴屏幕真实坐标 <y1\>起始点的Y轴屏幕真实坐标 <x2\>结束点的X轴屏幕真实坐标 <y2\>结束点的X轴屏幕真实坐标 [duration(ms)]可选参数，起始点到终点的滑动时长  
 使用时通过adb shell input swipe 200 200 400 400 2000即可模拟滑动从屏幕中坐标200，200 的位置到400，400结束，耗时2秒钟
 
 上面是通过adb命令实现，下面用Android代码实现上述功能
 ````java
        //获取Root权限，需要手机已经root
        Process process = Runtime.getRuntime().exec("su");
        dos = new DataOutputStream(process.getOutputStream());
        //模拟滑动  300 300 起始点X、Y轴坐标 900 1000 终点X、Y轴坐标 2000时间
        dos.writeBytes("input swipe 300 300 900 1000 2000" + "\n");
        //模拟点击  300 300 X、Y轴坐标
        dos.writeBytes("input tap 300 300" + "\n");
        //模拟输入
        dos.writeBytes("input text abcd" + "\n");
        //提交命令
        dos.flush();  
 ````