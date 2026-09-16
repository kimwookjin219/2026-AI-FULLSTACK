import 'package:flutter/material.dart';

//1. 구동 시작점 
void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar( title:  Text('내 첫 Flutter 앱 703')),
        body: Center( child: Text('Hello 하이 홍길동!')),
      ),
    ), 
  );
}

// Scaffold : 전체 기본 뼈대 - 상단 바, 본문 제공하는 기본 위젯
// appBar : 상단 타이틀바
// body : 몸통구성