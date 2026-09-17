// flutter 기본 UI 컴포넌트 라이브러리
import 'package:flutter/material.dart';
// riverpod 전역상태 관리 라이브러리
import 'package:flutter_riverpod/flutter_riverpod.dart';
// 메인 앱 설정
import 'app.dart';

// 앱 실행 진입점
void main() {
  // Flutter 엔진과 플랫폼 바인딩 초기화
  WidgetsFlutterBinding.ensureInitialized();
  
  // ProviderScope: Riverpod 전역 상태를 앱 전체에 주입 (Redux의 <Provider> 역할)
  runApp(const ProviderScope(child: App()));
}