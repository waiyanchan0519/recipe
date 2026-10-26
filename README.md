# 美味食譜 (Recipe App) - Android Native App in Kotlin

一個使用 **Kotlin** 與 **Jetpack Compose (Material 3)** 打造的現代化原生 Android 食譜 App，專為在 **Android Studio** 中直接開啟並運行而設計。

---

## 🌟 特色功能 (Features)

1. **豐富食譜探索 (Recipe Discovery)**
   - 包含經典中菜（台式阿嬤古早味滷肉飯）、日韓料理（日式滑蛋嫩牛丼、泡菜海鮮豆腐煲）、西式異國（蒜香白酒蛤蜊麵）、甜點烘焙（法式熔岩布朗尼）與健康減脂輕食（彩虹酪梨煎蝦沙拉、香煎蒜香檸檬鮭魚）等。
   - 即時關鍵字搜尋（可搜尋菜名、食材如「牛肉」、「蛤蜊」或標籤）。
   - 菜系分類標籤橫向滑動切換。

2. **智慧動態份量與食材換算 (Dynamic Servings Adjuster)**
   - 在食譜詳情頁可任意切換份量（如 2人份 ↔ 4人份），所有食材用量自動精確倍數計算！
   - 食材清單互動勾選（已備好的食材點擊即可劃掉）。
   - 一鍵將食材加入「備料清單」。

3. **步驟引導與內建烹飪計時器 (Interactive Step-by-Step & Cooking Timer)**
   - 步驟進度條提示（如：進度 2 / 4 步）。
   - 針對燉煮、煎烤步驟內建專屬計時器按鈕（如「啟動 45 分鐘計時」），可隨時暫停、重設、增加時間，時間到時給予提醒。
   - 提供大廚私房美味秘訣（Chef's Tips）。

4. **我的收藏 (Favorites)**
   - 隨時點擊心形圖示將喜歡的食譜加入收藏。

5. **備料清單 (Smart Shopping List)**
   - 前往超市採買時逐項勾選，並支援一鍵清除已購買項目。

---

## 🚀 如何在 Android Studio 中開啟與運行 (How to Open in Android Studio)

1. 開啟 **Android Studio**。
2. 在歡迎畫面選擇 **Open**（或在主選單選 **File -> Open...**）。
3. 導航至桌面，選擇 **`RecipeApp`** 資料夾並點擊 **OK**。
4. Android Studio 將會自動進行 Gradle Sync 並下載相依套件。
5. 連接 Android 手機（開啟 USB 偵錯）或啟動 Android 模擬器 (AVD)。
6. 點擊右上角綠色三角形的 **Run 'app'** 按鈕即可編譯並安裝執行！

---

## 🛠 技術架構 (Tech Stack)

- **語言**: Kotlin 1.9.24
- **UI 框架**: Jetpack Compose (BOM 2024.05.00)
- **設計風格**: Material Design 3 (M3)
- **狀態管理**: AndroidX ViewModel + Kotlin Coroutines & StateFlow
- **最小 SDK (minSdk)**: 24 (支援 Android 7.0 以上近 99% 裝置)
- **目標 SDK (targetSdk & compileSdk)**: 34 (Android 14)
