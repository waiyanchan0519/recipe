package com.example.recipeapp.data

import com.example.recipeapp.model.Category
import com.example.recipeapp.model.CookingStep
import com.example.recipeapp.model.Difficulty
import com.example.recipeapp.model.Ingredient
import com.example.recipeapp.model.Recipe

object SampleData {
    val recipes: List<Recipe> = listOf(
        Recipe(
            id = "braised_pork",
            title = "台式阿嬤古早味滷肉飯",
            subtitle = "油亮黏唇、醬香濃郁的白飯殺手",
            description = "精選帶皮五花肉切小丁，慢火煸出豬油香氣，加入紅蔥頭酥、冰糖炒出焦糖色澤，再與五香粉、醬油米酒慢火細煨，搭配入味的滷蛋與油豆腐，一口下去滿滿膠質。",
            category = Category.CHINESE,
            emoji = "🍲",
            prepTimeMinutes = 20,
            cookTimeMinutes = 45,
            defaultServings = 4,
            difficulty = Difficulty.MEDIUM,
            calories = 620,
            rating = 4.9,
            reviewCount = 384,
            tags = listOf("經典台味", "白飯殺手", "滿滿膠質", "家常宴客"),
            ingredients = listOf(
                Ingredient("帶皮五花肉", 600.0, "克", "切成約 1 公分寬小丁條"),
                Ingredient("紅蔥頭（或油蔥酥）", 80.0, "克", "切薄片炸香"),
                Ingredient("水煮蛋", 4.0, "顆", "去殼備用"),
                Ingredient("油豆腐", 4.0, "塊"),
                Ingredient("冰糖", 35.0, "克", "炒糖色用"),
                Ingredient("純釀造醬油", 100.0, "毫升"),
                Ingredient("金蘭醬油膏", 30.0, "毫升", "增添黏稠感與甘味"),
                Ingredient("台灣米酒", 80.0, "毫升"),
                Ingredient("五香粉", 1.0, "茶匙"),
                Ingredient("白胡椒粉", 0.5, "茶匙"),
                Ingredient("八角", 2.0, "粒"),
                Ingredient("熱水 / 高湯", 600.0, "毫升")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "煸香五花肉",
                    description = "熱鍋不放油，放入切小丁的五花肉，開中小火慢煎煸出多餘豬油，直到肉丁邊緣金黃微焦微縮，香氣四溢。",
                    timerMinutes = 8,
                    tip = "煸出的天然豬油保留在鍋中炒糖與香料，肉吃起來香而不膩。"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "炒糖色與熗酒",
                    description = "肉丁推至鍋邊，利用中間底油倒入冰糖，小火慢炒至融化呈現琥珀金黃色起微泡，將肉與焦糖均勻裹勻，沿鍋邊淋入米酒熗鍋激發酒香。",
                    timerMinutes = 3,
                    tip = "糖色炒得好，滷肉成品顏色紅亮誘人，不需加老抽人工色素。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "下醬香與靈魂油蔥酥",
                    description = "倒入醬油、醬油膏、五香粉、白胡椒粉及八角翻炒均勻，炒出醬香味後，加入香脆的紅蔥頭酥翻拌均勻。",
                    timerMinutes = 2,
                    tip = "油蔥酥一定要最後下翻炒幾秒即可，避免焦苦。"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "慢火煨燉與浸泡滷蛋",
                    description = "倒入600毫升熱水煮滾，加入水煮蛋及油豆腐，轉微火蓋上鍋蓋慢燉 45 分鐘，最後開中火收汁至醬汁濃稠掛勺。",
                    timerMinutes = 45,
                    tip = "燉好後若熄火靜置燜泡 1 小時再吃，肉更軟糯入味，滷蛋更甘甜。"
                )
            ),
            chefTips = listOf(
                "肉一定要手切成小條丁，口感比絞肉好十倍，更能釋放豐富膠原蛋白。",
                "湯汁不要完全收乾，淋在熱騰騰的白米飯上最是絕配！"
            ),
            primaryColorHex = 0xFFD84315L,
            secondaryColorHex = 0xFFFF8A65L
        ),
        Recipe(
            id = "gyudon_egg",
            title = "日式滑蛋嫩牛丼 (超快手)",
            subtitle = "15 分鐘暖心和風蓋飯，牛肉軟嫩蛋液滑潤",
            description = "日式定食店的人氣招牌！鮮甜的柴魚高湯、味醂與醬油慢煮洋蔥至甘甜，鋪上薄切牛五花肉片，最後淋入八分熟的滑嫩蛋液，甜鹹濃醇超開胃。",
            category = Category.QUICK,
            emoji = "🍱",
            prepTimeMinutes = 5,
            cookTimeMinutes = 10,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 510,
            rating = 4.8,
            reviewCount = 265,
            tags = listOf("15分鐘快手", "日式便當", "親子滑蛋", "一人食"),
            ingredients = listOf(
                Ingredient("牛五花肉片（火鍋切片）", 250.0, "克"),
                Ingredient("洋蔥", 0.5, "顆", "逆紋切粗絲"),
                Ingredient("雞蛋", 3.0, "顆", "粗略打散不要打勻"),
                Ingredient("柴魚高湯（或烹大師高湯）", 120.0, "毫升"),
                Ingredient("日式味醂", 2.0, "大匙"),
                Ingredient("日式清酒", 1.0, "大匙"),
                Ingredient("醬油", 2.5, "大匙"),
                Ingredient("砂糖", 1.0, "茶匙"),
                Ingredient("蔥花 / 七味粉", 1.0, "份", "裝飾提味")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "熬煮洋蔥高湯底",
                    description = "平底小鍋中倒入柴魚高湯、醬油、味醂、清酒與砂糖攪勻，加入切絲洋蔥，中火煮滾後轉中小火煮約 3-4 分鐘至洋蔥變透明軟甜。",
                    timerMinutes = 4,
                    tip = "洋蔥煮透釋放甘甜，是日式丼飯醬汁自然的美味來源。"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "鋪入牛五花片燙熟",
                    description = "將牛五花肉片一片片平鋪在洋蔥上，用筷子輕輕撥散，中火燜煮約 1-2 分鐘至牛肉變色 8 分熟，撈去表面浮沫。",
                    timerMinutes = 2,
                    tip = "牛肉不可久煮，肉片剛轉粉紅即可淋蛋，保持軟嫩多汁。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "分次淋入滑嫩蛋液",
                    description = "將略為打散的雞蛋先淋入 2/3，蓋鍋燜煮 20 秒，再淋入剩餘 1/3 蛋液，立即熄火蓋上鍋蓋燜 15 秒。",
                    timerMinutes = 1,
                    tip = "兩次倒蛋法能營造外層熟凝、中心半熟如絲綢般的滑蛋口感！"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "盛碗裝盤",
                    description = "將整鍋滑蛋牛肉優雅滑入盛有熱白飯的碗中，撒上蔥花與少許七味唐辛子即可享用。",
                    timerMinutes = null
                )
            ),
            chefTips = listOf(
                "打雞蛋時只要拿筷子切十幾下即可，保留蛋白與蛋黃交織的花紋最美味。",
                "不吃牛肉也可以換成雞腿肉丁（親子丼）或豬五花。"
            ),
            primaryColorHex = 0xFFF57C00L,
            secondaryColorHex = 0xFFFFB74DL
        ),
        Recipe(
            id = "vongole_pasta",
            title = "蒜香白酒蛤蜊義大利麵",
            subtitle = "鮮甜海味爆棚！經典義大利餐廳名菜",
            description = "初榨橄欖油溫柔煸出蒜片香氣，投入吐沙洗淨的大蛤蜊與乾辣椒，淋上芳香乾白葡萄酒高溫燜煮，乳化出濃郁鮮美醬汁包裹每一根彈牙麵條。",
            category = Category.WESTERN,
            emoji = "🍝",
            prepTimeMinutes = 15,
            cookTimeMinutes = 15,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 460,
            rating = 4.9,
            reviewCount = 412,
            tags = listOf("經典西餐", "海鮮控", "約會浪漫料理", "零失敗"),
            ingredients = listOf(
                Ingredient("直條義大利麵 (Spaghetti)", 180.0, "克"),
                Ingredient("新鮮活文蛤", 500.0, "克", "吐沙洗淨"),
                Ingredient("特級初榨橄欖油", 3.0, "大匙"),
                Ingredient("大蒜", 6.0, "瓣", "切薄片"),
                Ingredient("乾辣椒（或新鮮小紅椒）", 1.0, "根", "去籽切碎"),
                Ingredient("無甜不甜乾白葡萄酒", 80.0, "毫升"),
                Ingredient("新鮮巴西里（歐芹）", 1.0, "小把", "切碎"),
                Ingredient("海鹽 / 黑胡椒碎", 1.0, "適量"),
                Ingredient("煮麵水", 60.0, "毫升")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "煮麵條至彈牙",
                    description = "大湯鍋注水加 1% 鹽煮沸，放入義大利麵，按照包裝說明時間倒扣 2 分鐘（保留咬勁 Al dente），瀝水前保留半碗煮麵水。",
                    timerMinutes = 7,
                    tip = "煮麵水鹹度要像海水一樣，麵條才有底味。"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "低溫煸香蒜片與辣椒",
                    description = "平底深鍋倒入優質橄欖油與蒜片，開微火慢慢煸出蒜香呈金黃色，加入辣椒碎翻炒 10 秒激發辣香。",
                    timerMinutes = 3,
                    tip = "冷油冷鍋下蒜片，避免蒜片瞬間焦黑產生苦味。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "蛤蜊熗白酒燜開",
                    description = "轉大火倒入瀝乾的蛤蜊，立刻淋上白葡萄酒，蓋上鍋蓋大火燜煮 2 分鐘，看到蛤蜊一個個開口立即夾出備用防止肉質縮老。",
                    timerMinutes = 3,
                    tip = "開口一個夾出一個，蛤蜊顆顆飽滿爆汁！"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "麵汁乳化合體 (Emulsification)",
                    description = "將煮好的義大利麵倒入鍋中，加入 3-4 大匙煮麵水與少許橄欖油，劇烈搖晃翻炒讓油脂與澱粉水乳化成濃郁奶白醬汁，倒回蛤蜊與巴西里碎翻勻出鍋。",
                    timerMinutes = 2,
                    tip = "乳化是這道麵美味的關鍵，能讓每一根麵條都裹滿鮮甜海味醬汁。"
                )
            ),
            chefTips = listOf(
                "白酒請選擇清爽乾型（Dry White Wine，如Sauvignon Blanc或Pinot Grigio）。",
                "蛤蜊本身已有鹹味，調味時先試味再決定是否需要額外加鹽。"
            ),
            primaryColorHex = 0xFF0288D1L,
            secondaryColorHex = 0xFF4FC3F7L
        ),
        Recipe(
            id = "basil_pork",
            title = "正宗泰式打拋香辣豬肉飯",
            subtitle = "熱烈酸辣鑊氣！配焦邊荷包蛋最過癮",
            description = "泰國街頭最魂牽夢縈的快炒美味！肥瘦均勻豬絞肉在高溫鐵鍋中爆炒至香脆，與大蒜辣椒泥、魚露蠔油交織，最後拌入大把鮮香九層塔/打拋葉，香氣直擊靈魂。",
            category = Category.QUICK,
            emoji = "🍛",
            prepTimeMinutes = 10,
            cookTimeMinutes = 8,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 540,
            rating = 4.7,
            reviewCount = 188,
            tags = listOf("泰式料理", "下飯神器", "香辣過癮", "10分鐘"),
            ingredients = listOf(
                Ingredient("豬絞肉（半肥瘦）", 300.0, "克"),
                Ingredient("九層塔（或聖羅勒打拋葉）", 1.0, "大碗", "摘葉洗淨"),
                Ingredient("大蒜", 5.0, "瓣", "搗碎"),
                Ingredient("朝天椒 / 綠紅小辣椒", 3.0, "根", "切碎或搗泥"),
                Ingredient("長豇豆（或四季豆）", 4.0, "根", "切 1 公分小段"),
                Ingredient("小番茄", 4.0, "顆", "對半切（可選）"),
                Ingredient("泰式魚露", 1.5, "大匙"),
                Ingredient("特級蠔油", 1.0, "大匙"),
                Ingredient("椰糖（或二砂）", 1.0, "茶匙"),
                Ingredient("老抽醬色", 0.5, "茶匙", "增添焦糖色澤"),
                Ingredient("雞蛋", 2.0, "顆", "半煎炸荷包蛋")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "煎炸脆邊流心荷包蛋",
                    description = "鍋中倒入稍多的油加熱至冒輕煙，打入雞蛋，用勺子將熱油淋在蛋白邊緣，煎出蕾絲金黃焦邊而蛋黃保持流心，撈出控油盛在飯上。",
                    timerMinutes = 2
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "爆香辛香料與炒散肉末",
                    description = "留底油，下蒜末與辣椒碎大火爆炒出嗆辣香氣，倒入豬絞肉快速劃散煸炒，炒至肉色轉白微泛焦黃。",
                    timerMinutes = 3,
                    tip = "將蒜頭與辣椒放入研缽稍微搗碎，比刀切更能激發油脂精華。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "加入四季豆與複合調味醬",
                    description = "加入四季豆丁與小番茄翻炒，淋入魚露、蠔油、老抽與糖調配的醬汁，大火翻炒讓醬汁緊緊裹住肉末。",
                    timerMinutes = 2
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "投入九層塔瞬間出鍋",
                    description = "熄火，立即投入大把九層塔葉，利用鍋內餘溫快速翻炒 5 秒出香即盛盤。",
                    timerMinutes = 1,
                    tip = "九層塔千萬不能久炒，餘溫翻拌才能保持翠綠與清新香氣。"
                )
            ),
            chefTips = listOf(
                "吃的時候務必用叉子戳破流心蛋黃，讓蛋液融進辣肉飯裡，極度銷魂！"
            ),
            primaryColorHex = 0xFFC2185BL,
            secondaryColorHex = 0xFFF06292L
        ),
        Recipe(
            id = "chocolate_brownie",
            title = "法式熔岩生巧克力布朗尼",
            subtitle = "外層酥脆薄皮，內餡如生巧般軟糯濃郁",
            description = "採用 70% 苦甜黑巧克力與發酵無鹽黃油融合，烘烤出頂層如薄紙般酥脆的糖殼，內部濕潤濃郁近乎半熟熔岩，搭配一顆香草冰淇淋是人間至福。",
            category = Category.BAKING,
            emoji = "🧁",
            prepTimeMinutes = 15,
            cookTimeMinutes = 25,
            defaultServings = 6,
            difficulty = Difficulty.MEDIUM,
            calories = 380,
            rating = 4.9,
            reviewCount = 520,
            tags = listOf("下午茶甜點", "烘焙愛好者", "超濃黑巧", "免打發"),
            ingredients = listOf(
                Ingredient("70% 法芙娜苦甜黑巧克力", 180.0, "克"),
                Ingredient("無鹽發酵黃油", 110.0, "克"),
                Ingredient("室溫雞蛋", 3.0, "顆"),
                Ingredient("細砂糖", 90.0, "克"),
                Ingredient("低筋麵粉", 50.0, "克", "過篩"),
                Ingredient("純無糖可可粉", 25.0, "克", "過篩"),
                Ingredient("香草精", 1.0, "茶匙"),
                Ingredient("海鹽", 0.5, "茶匙", "平衡甜膩"),
                Ingredient("核桃碎", 50.0, "克", "先低溫烤香")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "隔水融化黑巧與黃油",
                    description = "將黑巧克力塊與無鹽黃油放入耐熱碗中，放在熱水鍋上隔水加熱（水溫不超過 60°C），攪拌至完全融化均勻柔順後放涼至微溫。",
                    timerMinutes = 5
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "全蛋加糖充分乳化打發",
                    description = "另取大碗打入 3 顆雞蛋、細砂糖與少許海鹽，用電動或手動打蛋器高速攪打 3-4 分鐘至顏色變淺發白且體積膨脹呈濃稠緞帶狀。",
                    timerMinutes = 4,
                    tip = "這是烤出布朗尼表面酥脆微裂糖殼（Shiny Crust）的最關鍵秘訣！"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "混勻粉類與堅果碎",
                    description = "將融化的巧克力黃油糊倒入蛋液中輕輕切拌均勻，篩入低筋麵粉與可可粉，用刮刀切拌至看不見乾粉即可，最後撒入烤香核桃碎拌勻。",
                    timerMinutes = 3
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "入模烘烤與掌握出爐時間",
                    description = "烤箱預熱 175°C，模具鋪烘焙紙，倒入麵糊刮平，送入烤箱中層烘烤 20-22 分鐘。竹籤插入邊緣乾燥、中心帶微黏巧克力屑即可出爐。",
                    timerMinutes = 22,
                    tip = "千萬不要烤過頭！冷卻後冷藏 4 小時口感如同生巧克力般紮實奢華。"
                )
            ),
            chefTips = listOf(
                "冷藏後切塊最工整平滑；吃之前微波加熱 15 秒即可重現流心熱感！"
            ),
            primaryColorHex = 0xFF4E342EL,
            secondaryColorHex = 0xFF8D6E63L
        ),
        Recipe(
            id = "avocado_shrimp_salad",
            title = "低卡彩虹酪梨鮮蝦溫沙拉",
            subtitle = "高蛋白、好油脂！健身減脂期的滿分盛宴",
            description = "彈牙鮮美的大蝦仁用香蒜黑椒乾煎，搭配富含不飽和脂肪酸的綿密哈斯酪梨、清甜彩椒、櫻桃番茄與綜合水耕生菜，淋上自製油醋汁，清爽無負擔。",
            category = Category.FITNESS,
            emoji = "🥗",
            prepTimeMinutes = 10,
            cookTimeMinutes = 5,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 290,
            rating = 4.8,
            reviewCount = 143,
            tags = listOf("生酮友好", "減脂瘦身", "高蛋白低卡", "輕食便當"),
            ingredients = listOf(
                Ingredient("鮮蝦仁（大號）", 12.0, "隻", "開背去蝦線"),
                Ingredient("成熟哈斯酪梨 (Avocado)", 1.0, "顆", "切厚片"),
                Ingredient("綜合生菜葉（羽衣甘藍、芝麻葉）", 120.0, "克"),
                Ingredient("彩色櫻桃番茄", 8.0, "顆", "對半切"),
                Ingredient("水煮溏心蛋", 2.0, "顆", "切半"),
                Ingredient("特級初榨橄欖油", 2.0, "大匙"),
                Ingredient("新鮮檸檬汁（或蘋果醋）", 1.5, "大匙"),
                Ingredient("法式芥末籽醬", 1.0, "茶匙"),
                Ingredient("純蜂蜜", 1.0, "茶匙"),
                Ingredient("現磨黑胡椒與海鹽", 1.0, "適量")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "調製黃金比例芥末油醋汁",
                    description = "將特級橄欖油、鮮檸檬汁、芥末籽醬、蜂蜜、海鹽和現磨黑胡椒放入小玻璃瓶中，用力搖晃 20 秒直到完全乳化濃稠。",
                    timerMinutes = 2
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "香煎彈牙大蝦仁",
                    description = "平底鍋抹少許橄欖油燒熱，下蒜碎與開背蝦仁，雙面各煎 1.5 分鐘至兩面金黃變紅卷曲，撒上海鹽黑胡椒即可起鍋。",
                    timerMinutes = 3,
                    tip = "蝦肉剛斷生最鮮甜多汁，避免久煎肉質變柴。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "組裝彩虹健康碗",
                    description = "大沙拉碗底部鋪上洗淨甩乾的綜合脆生菜，依序整齊碼上酪梨片、鮮紅小番茄、金黃煎蝦與溏心蛋，均勻淋上油醋汁。",
                    timerMinutes = 2
                )
            ),
            chefTips = listOf(
                "生菜洗淨後一定要用蔬菜脫水器徹底甩乾，醬汁才能緊密掛在葉片上不稀釋味蕾！"
            ),
            primaryColorHex = 0xFF2E7D32L,
            secondaryColorHex = 0xFF81C784L
        ),
        Recipe(
            id = "kimchi_tofu_soup",
            title = "韓式泡菜海鮮嫩豆腐煲",
            subtitle = "微辣酸爽熱氣騰騰，咕嘟咕嘟暖胃驅寒",
            description = "韓劇同款熱騰騰紅亮陶鍋！熟成老泡菜與香菇炒出濃郁酸辣香氣，注入小魚乾昆布高湯，加入滑嫩嫩豆腐、鮮蝦蛤蜊與五花肉片，打入一顆生蛋黃攪開，濃郁醇香。",
            category = Category.JAPANESE,
            emoji = "🍲",
            prepTimeMinutes = 10,
            cookTimeMinutes = 15,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 360,
            rating = 4.8,
            reviewCount = 210,
            tags = listOf("暖身暖胃", "韓風必吃", "低卡高飽足", "陶鍋料理"),
            ingredients = listOf(
                Ingredient("韓國熟成泡菜", 150.0, "克", "含泡菜汁"),
                Ingredient("嫩豆腐（絹豆腐）", 1.0, "盒", "約300克"),
                Ingredient("五花肉片", 100.0, "克"),
                Ingredient("鮮蝦與蛤蜊", 8.0, "份"),
                Ingredient("韓式粗辣椒粉", 1.5, "大匙"),
                Ingredient("韓式大醬（或生抽）", 1.0, "大匙"),
                Ingredient("小魚乾昆布高湯", 400.0, "毫升"),
                Ingredient("大蔥段 / 洋蔥", 0.5, "根"),
                Ingredient("香油", 1.0, "大匙"),
                Ingredient("鮮雞蛋黃", 1.0, "顆")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "炒出紅油與焦香",
                    description = "陶鍋或小湯鍋中倒入香油，中小火爆香蔥白與洋蔥絲，加入五花肉片煸炒出油，再加入韓式辣椒粉炒出誘人紅油。",
                    timerMinutes = 3
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "炒透老泡菜並加高湯煮滾",
                    description = "倒入切碎的泡菜及泡菜汁翻炒 2 分鐘激發酸香，倒入 400 毫升小魚乾昆布高湯，大火煮滾後轉中火煮 5 分鐘出味。",
                    timerMinutes = 5
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "大塊嫩豆腐與海鮮入鍋",
                    description = "用勺子大塊舀入嫩豆腐，加入洗淨的蛤蜊與鮮蝦，蓋鍋蓋煮 3-4 分鐘至蛤蜊全開口，加入生抽或鹽調整鹹度。",
                    timerMinutes = 4
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "壓軸生蛋黃與青蔥",
                    description = "熄火前在鍋正中央磕入一顆新鮮生蛋黃，撒上蔥綠圈，端上桌趁熱攪散讓湯汁更加圓潤柔滑。",
                    timerMinutes = 1
                )
            ),
            chefTips = listOf(
                "一定要選微發酵帶酸味的老泡菜，湯底才會深邃回甘有層次！"
            ),
            primaryColorHex = 0xFFD32F2FL,
            secondaryColorHex = 0xFFEF5350L
        ),
        Recipe(
            id = "pan_salmon",
            title = "金黃香脆蒜香檸檬煎鮭魚",
            subtitle = "魚皮薄脆如薯片，魚肉粉嫩豐腴爆汁",
            description = "厚切挪威大西洋鮭魚菲力，利用魚皮自身豐沛Omega-3油脂乾烙煎出極致酥脆金黃外殼，出鍋前浸潤在蒜香黃油與鮮檸檬迷迭香中，五星級西餐廳水準。",
            category = Category.FITNESS,
            emoji = "🐟",
            prepTimeMinutes = 5,
            cookTimeMinutes = 10,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 420,
            rating = 4.9,
            reviewCount = 310,
            tags = listOf("優質蛋白", "Omega-3", "西餐排餐", "新手必學"),
            ingredients = listOf(
                Ingredient("新鮮帶皮鮭魚菲力", 2.0, "塊", "每塊約180克"),
                Ingredient("大蒜", 4.0, "瓣", "拍裂去皮"),
                Ingredient("無鹽黃油", 20.0, "克"),
                Ingredient("新鮮迷迭香（或百里香）", 2.0, "枝"),
                Ingredient("新鮮黃檸檬", 1.0, "顆", "半顆擠汁半顆切片"),
                Ingredient("特級初榨橄欖油", 1.0, "茶匙"),
                Ingredient("粗粒海鹽與現磨黑胡椒", 1.0, "適量"),
                Ingredient("綠蘆筍（配菜）", 6.0, "根", "燙熟備用")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "擦乾魚身與皮面刻花",
                    description = "廚房紙巾徹底吸乾鮭魚表面水份，在魚皮上淺劃幾刀防受熱捲曲，兩面均勻撒上海鹽與現磨黑胡椒醃製 5 分鐘。",
                    timerMinutes = 5,
                    tip = "魚皮表面徹底乾燥是煎出脆皮的最關鍵秘訣！"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "下鍋煎脆魚皮",
                    description = "平底鍋加微量油中火燒熱，魚皮朝下放入鍋中，用鍋鏟輕壓魚身 15 秒使其緊貼鍋底，保持中小火慢煎約 5 分鐘至魚皮金黃香脆、魚肉側面轉白達 2/3。",
                    timerMinutes = 5
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "翻面與黃油香草淋澆 (Basting)",
                    description = "翻面煎肉面約 1.5 分鐘，放入黃油、拍裂蒜瓣、迷迭香與檸檬片，傾斜鍋身用湯匙不斷將融化香氣四溢的蒜香黃油淋在魚身上。",
                    timerMinutes = 2,
                    tip = "Basting（澆淋法）能讓魚肉中心熟得柔和且吸滿香草奶香。"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "擠檸檬汁靜置盛盤",
                    description = "熄火前擠入新鮮檸檬汁激發果香，將鮭魚移至溫熱餐盤靜置 2 分鐘讓肉汁回流，搭配嫩蘆筍即可大快朵頤。",
                    timerMinutes = 2
                )
            ),
            chefTips = listOf(
                "鮭魚千萬別煎到全乾全硬，中心保持微微半透明淡粉色時最多汁美味！"
            ),
            primaryColorHex = 0xFFE64A19L,
            secondaryColorHex = 0xFFFF7043L
        )
    )
}
