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
        ),
        Recipe(
            id = "sichuan_mapo_tofu",
            title = "正宗川味香辣麻婆豆腐",
            subtitle = "麻、辣、鮮、香、燙、嫩、酥、捆，八字精髓下飯之王",
            description = "四川名廚傳承經典配方！精選嫩板豆腐切丁先用鹽水汆燙去豆腥保滑嫩，以純牛絞肉慢火煸至酥脆香乾，融入郫縣老豆瓣醬與永川豆豉炒出紅亮紅油，起鍋前連勾三次米湯芡，撒上剛現磨的大紅袍花椒粉，熱氣撲鼻令人胃口大開。",
            category = Category.CHINESE,
            emoji = "🌶️",
            prepTimeMinutes = 15,
            cookTimeMinutes = 12,
            defaultServings = 3,
            difficulty = Difficulty.MEDIUM,
            calories = 340,
            rating = 4.9,
            reviewCount = 428,
            tags = listOf("經典川菜", "麻辣鮮香", "白飯殺手", "豆腐名菜"),
            ingredients = listOf(
                Ingredient("嫩豆腐（或板豆腐）", 400.0, "克", "切 1.5 公分方丁"),
                Ingredient("牛肉末（或豬絞肉）", 120.0, "克", "慢火煸酥"),
                Ingredient("正宗郫縣豆瓣醬", 2.0, "大匙", "細細剁碎"),
                Ingredient("四川豆豉", 1.0, "大匙", "略微壓碎"),
                Ingredient("大紅袍花椒粉", 1.5, "茶匙", "起鍋現磨撒頂"),
                Ingredient("蒜末與薑末", 2.0, "大匙"),
                Ingredient("青蒜苗（蒜苗圈）", 2.0, "根", "切小斜段"),
                Ingredient("高湯或溫水", 250.0, "毫升"),
                Ingredient("優質醬油與糖", 1.0, "大匙", "平衡鹹度"),
                Ingredient("太白粉水（水芡）", 3.0, "大匙", "分三次勾芡")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "豆腐鹽水浸燙",
                    description = "湯鍋加水加半茶匙鹽煮微滾，放入切塊豆腐丁浸燙 2 分鐘後撈出泡溫水備用。",
                    timerMinutes = 2,
                    tip = "鹽水燙豆腐能逼出豆腥味，並使豆腐緊實不易在翻炒時碎裂。"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "煸香酥脆牛肉末",
                    description = "熱鍋倒入適量油，下牛肉末開中小火慢炒，將牛肉水份煸乾至邊緣焦黃微酥、油脂清澈。",
                    timerMinutes = 4,
                    tip = "牛肉一定要煸至酥脆化渣，這就是正宗麻婆豆腐靈魂中的「酥」。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "炒出豆瓣紅油與醬香",
                    description = "轉小火，加入剁碎的郫縣豆瓣醬與豆豉慢炒出深紅油亮色澤與醇厚醬香，再下薑蒜末翻炒爆香。",
                    timerMinutes = 2
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "推入豆腐煨煮入味",
                    description = "倒入 250 毫升溫高湯煮沸，輕輕滑入瀝乾的豆腐塊，加少許糖調味，中小火慢煨 3 分鐘讓豆腐吸飽麻辣湯汁。",
                    timerMinutes = 3,
                    tip = "切忌用鍋鏟亂翻切碎豆腐，應用鍋鏟背面輕輕推動。"
                ),
                CookingStep(
                    stepNumber = 5,
                    title = "三段式勾芡與撒花椒",
                    description = "下蒜苗白段，分三次淋入水澱粉：第一次定味、第二次鎖汁、第三次亮芡；起鍋裝盤，均勻撒上剛現磨的大紅袍花椒粉與蒜苗綠圈。",
                    timerMinutes = 2,
                    tip = "三次勾芡能讓紅油與濃芡完美裹在每塊豆腐上，不吐水不沉澱。"
                )
            ),
            chefTips = listOf(
                "花椒粉必須起鍋出盤後現磨撒在頂層，利用熱蒸氣逼出麻香，若提早下鍋煮容易發苦。"
            ),
            primaryColorHex = 0xFFC62828L,
            secondaryColorHex = 0xFFFF5722L
        ),
        Recipe(
            id = "three_cup_chicken",
            title = "台式熱炒濃郁塔香三杯雞",
            subtitle = "一杯麻油、一杯米酒、一杯醬油，焦糖金黃肉嫩多汁",
            description = "台灣熱炒店與家常砂鍋的第一名台柱！以濃醇黑麻油低溫慢煸老薑片至乾癟捲曲，放入仿土雞腿肉煎出金黃脆皮，注入醇米酒、純釀醬油與冰糖大火燒滾收汁至濃稠焦糖色，起鍋前投入滿滿九層塔與砂鍋蓋邊熗米酒，香氣席捲整個廚房。",
            category = Category.CHINESE,
            emoji = "🍗",
            prepTimeMinutes = 15,
            cookTimeMinutes = 18,
            defaultServings = 4,
            difficulty = Difficulty.MEDIUM,
            calories = 520,
            rating = 4.9,
            reviewCount = 356,
            tags = listOf("經典台味", "熱炒必吃", "砂鍋料理", "鹹香甘甜"),
            ingredients = listOf(
                Ingredient("仿土雞腿肉（切大塊）", 600.0, "克"),
                Ingredient("帶皮老薑", 50.0, "克", "切薄片約 20 片"),
                Ingredient("整粒大蒜瓣", 12.0, "瓣", "去皮保持整粒"),
                Ingredient("新鮮九層塔", 2.0, "大把", "洗淨瀝乾"),
                Ingredient("純黑麻油", 2.0, "大匙"),
                Ingredient("食用油（耐高溫沙拉油）", 1.0, "大匙", "混油防麻油變苦"),
                Ingredient("台灣米酒", 60.0, "毫升"),
                Ingredient("純釀造醬油", 40.0, "毫升"),
                Ingredient("醬油膏", 20.0, "毫升", "增添黏稠焦糖感"),
                Ingredient("冰糖（或二砂）", 25.0, "克"),
                Ingredient("紅辣椒", 1.0, "根", "斜切段添色")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "黑麻油慢火煸透薑片",
                    description = "熱鍋倒入食用油與黑麻油，開小火將老薑薄片平鋪鍋底，慢火煸煎約 5 分鐘至邊緣微焦捲曲發出辛香味，下整粒蒜瓣炒至微金黃。",
                    timerMinutes = 5,
                    tip = "黑麻油不可高溫大火爆炒以免發苦，混入少許耐熱沙拉油能護住油香。"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "雞腿肉下鍋煸煎上色",
                    description = "轉中大火，下雞腿肉塊，先將雞皮面朝下煎出多餘雞油，翻面煎炒至雞肉表面整體泛出金黃焦邊。",
                    timerMinutes = 4
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "三杯調味大火燒滾煨煮",
                    description = "加入冰糖炒化上色，沿鍋邊淋入醬油、醬油膏與米酒，煮沸後轉中小火蓋上鍋蓋慢煨 8 分鐘讓雞肉充分入味熟軟。",
                    timerMinutes = 8
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "大火收汁與砂鍋熗塔香",
                    description = "開大火翻炒收乾湯汁至醬汁濃稠油亮均勻裹在每塊雞肉上；砂鍋預熱燒燙，倒入雞肉、投入大把九層塔葉與辣椒，蓋上鍋蓋沿蓋緣淋入一匙米酒燜 15 秒開蓋上桌！",
                    timerMinutes = 2,
                    tip = "鍋蓋緣淋米酒能利用高溫砂鍋瞬間蒸發激發極致鑊氣！"
                )
            ),
            chefTips = listOf(
                "雞肉推薦挑選肉質緊實的仿土雞腿，口感比肉雞更彈牙，耐煨不爛。"
            ),
            primaryColorHex = 0xFFBF360CL,
            secondaryColorHex = 0xFFFF7043L
        ),
        Recipe(
            id = "japanese_pork_curry",
            title = "日式熟成厚切豬排濃咖哩",
            subtitle = "慢炒焦糖洋蔥基底，搭配外酥內多汁金黃炸豬排",
            description = "日本洋食店的殿堂級經典！將大量洋蔥用中小火耐心慢炒至深琥珀焦糖色，釋放驚人天然甘甜，與胡蘿蔔、馬鈴薯、富士蘋果泥慢燉出濃郁醇厚咖哩醬；蓋上一塊外皮酥脆卡滋、內裡粉嫩爆汁的現炸厚切大里肌豬排，每一口都是至高無上的幸福。",
            category = Category.JAPANESE,
            emoji = "🍛",
            prepTimeMinutes = 25,
            cookTimeMinutes = 35,
            defaultServings = 4,
            difficulty = Difficulty.HARD,
            calories = 780,
            rating = 4.9,
            reviewCount = 612,
            tags = listOf("經典和風", "日式洋食", "黃金炸豬排", "濃郁咖哩"),
            ingredients = listOf(
                Ingredient("厚切豬大里肌肉排", 4.0, "片", "每片約 150 克"),
                Ingredient("洋蔥", 2.0, "顆", "順紋切薄絲"),
                Ingredient("馬鈴薯", 2.0, "顆", "滾刀切大塊"),
                Ingredient("胡蘿蔔", 1.0, "根", "滾刀切塊"),
                Ingredient("日式咖哩塊（中辛或甜味）", 1.0, "盒", "約 180 克"),
                Ingredient("富士蘋果", 0.5, "顆", "去皮磨成泥"),
                Ingredient("黑巧克力（70%）", 10.0, "克", "秘方增添深度"),
                Ingredient("日式無糖優格或牛奶", 2.0, "大匙"),
                Ingredient("日式生麵包粉 (Panko)", 100.0, "克"),
                Ingredient("中筋麵粉與全蛋液", 1.0, "份", "過三關炸粉用"),
                Ingredient("高湯或清水", 800.0, "毫升")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "慢炒靈魂焦糖洋蔥 (Caramelized Onion)",
                    description = "深湯鍋放入黃油與少許油，加入全部洋蔥絲，中微火耐心翻炒 15-20 分鐘，直到洋蔥體積縮小至 1/4、顏色轉為深琥珀金黃焦糖色。",
                    timerMinutes = 18,
                    tip = "焦糖化洋蔥是日式頂級咖哩醬汁甘甜醇厚的最核心靈魂！"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "加入根莖蔬果慢燉",
                    description = "加入胡蘿蔔塊與馬鈴薯翻炒 2 分鐘，倒入 800 毫升水或高湯，大火煮滾後撈除浮沫，加入蘋果泥，轉微火慢燉 15 分鐘至蔬菜軟透。",
                    timerMinutes = 15
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "融化咖哩塊與熟成增味",
                    description = "熄火，將咖哩塊掰成小塊放入鍋中攪拌至完全融化無顆粒，開微火續煮 5 分鐘，加入黑巧克力碎與優格攪勻出光澤。",
                    timerMinutes = 5,
                    tip = "少許純黑巧克力可中和甘味並賦予醬汁如咖啡店般的深邃苦甜回甘。"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "雙溫炸出外酥裡嫩厚切豬排",
                    description = "豬排斷筋拍平撒海鹽黑椒，依序裹上麵粉、蛋液、日式粗麵包粉。160°C 油溫先炸 4 分鐘定型鎖汁，撈起瀝油靜置 3 分鐘，再以 180°C 高溫搶酥炸 1 分鐘出鍋切厚條。",
                    timerMinutes = 6,
                    tip = "兩次油炸法：低溫炸熟肉心、高溫逼油外皮金黃酥脆！"
                ),
                CookingStep(
                    stepNumber = 5,
                    title = "盛盤組裝",
                    description = "白飯塑形盛入深盤，淋上滾燙濃醇蔬菜咖哩，優雅擺上切塊金黃豬排，附上醃福神漬即可大快朵頤。",
                    timerMinutes = null
                )
            ),
            chefTips = listOf(
                "咖哩放置隔夜（熟成一晚）加熱再吃，所有食材風味相互交融，美味程度更上一層樓！"
            ),
            primaryColorHex = 0xFFE65100L,
            secondaryColorHex = 0xFFFFB300L
        ),
        Recipe(
            id = "korean_tteokbokki",
            title = "首爾街頭香辣起司炒年糕",
            subtitle = "Q彈年糕裹滿甜辣紅醬，濃郁牽絲莫札瑞拉起司",
            description = "弘大路邊布帳馬車的超人氣宵夜！小魚乾昆布高湯作為鮮味基底，融入韓國純正太陽草辣醬、粗細辣椒粉、糖稀與釜山魚板慢火煮出濃稠紅汁，年糕吸飽湯汁極致軟糯入味，最後鋪上厚厚一層莫札瑞拉起司燜至融化，甜辣拉絲讓人欲罷不能。",
            category = Category.JAPANESE,
            emoji = "🫕",
            prepTimeMinutes = 10,
            cookTimeMinutes = 12,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 490,
            rating = 4.8,
            reviewCount = 289,
            tags = listOf("韓式街頭", "甜辣拉絲", "下酒宵夜", "年糕控"),
            ingredients = listOf(
                Ingredient("韓國純米年糕條", 300.0, "克", "洗淨瀝乾"),
                Ingredient("釜山扁魚板", 2.0, "片", "切菱形塊"),
                Ingredient("大蔥（大蔥圈）", 1.0, "根", "斜切段"),
                Ingredient("高麗菜葉", 2.0, "片", "切粗塊"),
                Ingredient("熟水煮蛋", 2.0, "顆", "去殼"),
                Ingredient("莫札瑞拉披薩起司絲", 80.0, "克", "頂部拉絲"),
                Ingredient("韓國辣醬 (Gochujang)", 2.5, "大匙"),
                Ingredient("韓國細辣椒粉", 1.0, "大匙"),
                Ingredient("純釀醬油", 1.0, "大匙"),
                Ingredient("玉米糖稀（或蜂蜜砂糖）", 2.0, "大匙"),
                Ingredient("小魚乾昆布高湯", 400.0, "毫升"),
                Ingredient("熟白芝麻", 1.0, "茶匙", "裝飾")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "調製韓式黃金辣炒醬底",
                    description = "平底深炒鍋倒入 400 毫升小魚乾昆布高湯，加入韓國辣醬、細辣椒粉、醬油與玉米糖稀，用湯匙充分攪勻煮滾。",
                    timerMinutes = 2
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "加入年糕與魚板慢煨",
                    description = "倒入年糕條、魚板塊與高麗菜葉，轉中小火慢煨 6-8 分鐘，期間頻繁輕輕翻動底部防黏鍋，直到醬汁漸漸濃稠、年糕變得軟糯彈牙。",
                    timerMinutes = 7,
                    tip = "用小火慢煨能讓高湯鮮味與辣醬完全滲透進年糕米心。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "加入大蔥與水煮蛋",
                    description = "加入切段大蔥與水煮蛋，滾拌均勻吸收濃稠紅亮醬汁約 1 分鐘。",
                    timerMinutes = 1
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "撒起司燜至融化拉絲",
                    description = "轉微火，將莫札瑞拉起司絲均勻厚鋪在表面，蓋上鍋蓋燜 2 分鐘直到起司完全融化，撒上熟白芝麻趁熱享用超長牽絲！",
                    timerMinutes = 2,
                    tip = "吃的時候記得拿湯匙戳破水煮蛋，將蛋黃壓碎拌在甜辣醬汁裡最是銷魂！"
                )
            ),
            chefTips = listOf(
                "如果年糕原本是冷凍硬塊，料理前先泡冷水 15 分鐘，煮起來更加 Q 彈不裂紋。"
            ),
            primaryColorHex = 0xFFD50000L,
            secondaryColorHex = 0xFFFF5252L
        ),
        Recipe(
            id = "classic_carbonara",
            title = "正宗義式培根蛋黃羅馬麵 (Carbonara)",
            subtitle = "純粹義大利無鮮奶油傳統！黑椒、佩克里諾乳酪與蛋黃的絲滑魔術",
            description = "羅馬四大經典義大利麵之首！嚴守無鮮奶油、無大蒜的義大利傳統老饕做法，選用風乾豬面頰肉（Guanciale）或厚切煙燻培根慢煎逼出豐沛油脂，將剛出鍋的彈牙直麵與生蛋黃、大量佩克里諾羊乳酪粉離火劇烈乳化翻拌，打造如絲綢般包覆麵條的濃郁金黃奶香醬汁。",
            category = Category.WESTERN,
            emoji = "🍝",
            prepTimeMinutes = 10,
            cookTimeMinutes = 10,
            defaultServings = 2,
            difficulty = Difficulty.MEDIUM,
            calories = 580,
            rating = 4.9,
            reviewCount = 478,
            tags = listOf("經典西餐", "正統羅馬", "零鮮奶油", "15分鐘快手"),
            ingredients = listOf(
                Ingredient("義大利直麵 (Spaghetti No.5)", 180.0, "克"),
                Ingredient("厚切煙燻培根（或風乾豬面頰肉）", 100.0, "克", "切 0.8 公分粗條"),
                Ingredient("新鮮可生食級生蛋黃", 3.0, "顆"),
                Ingredient("新鮮全蛋", 1.0, "顆"),
                Ingredient("佩克里諾羊乳酪粉 (Pecorino Romano)", 40.0, "克", "細磨粉"),
                Ingredient("帕瑪森乳酪粉 (Parmigiano Reggiano)", 20.0, "克", "細磨粉"),
                Ingredient("現磨粗粒黑胡椒", 1.5, "茶匙", "熱鍋先乾烙乾炒出香"),
                Ingredient("煮麵水", 50.0, "毫升")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "煮麵條至咬勁彈牙 (Al dente)",
                    description = "深鍋注水加 1% 鹽沸騰，放入直麵，按照包裝說明倒扣 2 分鐘煮好瀝乾，務必保留半碗濃郁煮麵水備用。",
                    timerMinutes = 8
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "調製黃金蛋黃乳酪醬糊",
                    description = "大碗中打入 3 顆蛋黃與 1 顆全蛋，加入佩克里諾羊乳酪粉、帕瑪森乳酪粉與大半黑胡椒碎，用叉子快速打散成濃稠金黃糊狀。",
                    timerMinutes = 2
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "低溫煸脆培根與乾烙黑椒",
                    description = "平底鍋不放油，放入培根條以中小火慢慢逼出油脂，煎至邊緣微焦酥脆撈出一半備用，鍋內底油倒入剩餘黑胡椒碎微炒 10 秒逼出辛香。",
                    timerMinutes = 5,
                    tip = "煸出的天然培根鹹香油脂是整道麵乳化的關鍵媒介。"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "離火乳化翻拌 (Emulsification)",
                    description = "將煮好的熱麵條投入培根油鍋拌勻吸收肉香。鍋子徹底移離火源冷卻 20 秒，倒入蛋黃乳酪糊與 3-4 大匙溫煮麵水，迅速劇烈挑拌晃鍋，讓餘溫將蛋糊乳化成滑順奶油狀醬汁！",
                    timerMinutes = 2,
                    tip = "必須離火翻拌！若鍋溫過高蛋液會瞬間凝結成炒蛋碎，失去滑潤如絲的口感。"
                ),
                CookingStep(
                    stepNumber = 5,
                    title = "盛盤與頂部脆培根裝飾",
                    description = "用大叉捲起麵條盛入溫熱餐盤，淋上鍋底每一滴濃醬，頂部灑上剛預留的香脆培根塊與現磨黑胡椒。",
                    timerMinutes = null
                )
            ),
            chefTips = listOf(
                "一定要選用新鮮高品質的生食級雞蛋；離火利用餘溫乳化是百年義式大廚不傳秘方。"
            ),
            primaryColorHex = 0xFFFF8F00L,
            secondaryColorHex = 0xFFFFD54FL
        ),
        Recipe(
            id = "matcha_basque_cheesecake",
            title = "京都宇治抹茶巴斯克焦香乳酪",
            subtitle = "焦黑微苦焦糖外殼，切開半熟軟心生乳酪雙重奏",
            description = "甜點控心中的極致夢幻逸品！西班牙巴斯克乳酪蛋糕融合日本頂級宇治抹茶粉，高溫烘烤出表面微帶焦黑微苦焦糖層，鎖住內部如生乳酪般滑潤半熟流心質地，濃郁乳酪奶香與抹茶深邃回甘完美交織，免打發零失敗。",
            category = Category.BAKING,
            emoji = "🧀",
            prepTimeMinutes = 20,
            cookTimeMinutes = 25,
            defaultServings = 6,
            difficulty = Difficulty.MEDIUM,
            calories = 360,
            rating = 4.9,
            reviewCount = 534,
            tags = listOf("烘焙下午茶", "抹茶控", "免打發零失敗", "半熟流心"),
            ingredients = listOf(
                Ingredient("原味奶油乳酪 (Cream Cheese)", 350.0, "克", "室溫充分軟化"),
                Ingredient("宇治五十鈴或若竹抹茶粉", 15.0, "克", "過篩"),
                Ingredient("細砂糖", 85.0, "克"),
                Ingredient("室溫全雞蛋", 3.0, "顆"),
                Ingredient("動物性鮮奶油 (35%脂肪)", 180.0, "毫升"),
                Ingredient("玉米澱粉（或低筋麵粉）", 8.0, "克", "過篩"),
                Ingredient("新鮮檸檬汁", 1.0, "茶匙", "提亮果酸解膩"),
                Ingredient("香草精", 0.5, "茶匙")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "軟化乳酪與攪拌順滑",
                    description = "烤箱預熱 220°C，6 吋圓形活底模具鋪上沾濕微揉皺的烘焙紙。軟化的奶油乳酪加入細砂糖，用刮刀或手動打蛋器順時針慢速按壓順滑至無顆粒羽毛狀。",
                    timerMinutes = 4
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "分次加入蛋液乳化",
                    description = "將 3 顆雞蛋依序一顆一顆加入乳酪糊中，每加一顆充分攪拌均勻再加下一顆，加入檸檬汁與香草精拌勻。",
                    timerMinutes = 3
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "抹茶粉鮮奶油均質融合",
                    description = "將過篩的抹茶粉分次倒入常溫動物鮮奶油中，用迷你打蛋器徹底攪散至濃綠無顆粒，倒回乳酪蛋糊中輕輕切拌均勻，最後篩入玉米粉拌勻，過濾網一次使麵糊更細膩。",
                    timerMinutes = 4,
                    tip = "抹茶粉先與少量鮮奶油調勻過篩，可避免直接倒入乳酪糊產生乾燥小顆粒。"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "高溫快速烘烤形成焦黑層",
                    description = "將麵糊倒入模具，震出大氣泡，送入 220°C 烤箱中上層烘烤 22-25 分鐘，表面呈現標誌性深焦褐色、搖晃模具時中心如布丁般輕微晃動即可出爐！",
                    timerMinutes = 24,
                    tip = "出爐時中心輕晃代表內部保持奢華半熟流心，切勿烤過頭成全熟蛋糕。"
                ),
                CookingStep(
                    stepNumber = 5,
                    title = "冷卻與冷藏熟成切塊",
                    description = "室溫徹底放涼後，連同模具密封放入冰箱冷藏 4 小時以上（冷藏過夜風味更濃郁最佳），切刀熱水溫燙擦乾後切塊，切面平整如生巧克力。",
                    timerMinutes = null
                )
            ),
            chefTips = listOf(
                "所有材料（奶油乳酪、雞蛋、鮮奶油）務必保持室溫，否則混合時容易油水分離。"
            ),
            primaryColorHex = 0xFF2E7D32L,
            secondaryColorHex = 0xFF66BB6AL
        ),
        Recipe(
            id = "shakshuka_eggs",
            title = "地中海番茄北非蛋 (Shakshuka)",
            subtitle = "酸甜香濃番茄甜椒醬汁，燜出金黃溏心流心蛋",
            description = "風靡歐美的早午餐（Brunch）超級巨星！以特級橄欖油慢火炒透洋蔥、紅黃甜椒與大蒜，融入孜然粉、紅椒粉與新鮮番茄慢熬成濃稠馥郁的酸甜醬底，在醬汁中挖三個小窩打入雞蛋，撒上菲達羊乳酪碎蓋燜至蛋白凝固蛋黃流心，撕一塊酥脆法棍沾裹食用，幸福感爆棚。",
            category = Category.QUICK,
            emoji = "🍳",
            prepTimeMinutes = 8,
            cookTimeMinutes = 12,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 310,
            rating = 4.8,
            reviewCount = 345,
            tags = listOf("早午餐Brunch", "鑄鐵鍋料理", "流心蛋黃", "15分鐘快手"),
            ingredients = listOf(
                Ingredient("新鮮雞蛋", 3.0, "顆"),
                Ingredient("熟透牛番茄（或去皮番茄碎罐頭）", 2.0, "顆", "切小塊約 250 克"),
                Ingredient("紅甜椒與黃甜椒", 1.0, "顆", "去籽切條絲"),
                Ingredient("洋蔥", 0.5, "顆", "切小碎丁"),
                Ingredient("大蒜", 3.0, "瓣", "切薄片"),
                Ingredient("特級初榨橄欖油", 2.0, "大匙"),
                Ingredient("孜然粉 (Cumin)", 1.0, "茶匙"),
                Ingredient("西班牙煙燻紅椒粉 (Paprika)", 1.0, "茶匙"),
                Ingredient("希臘菲達乳酪碎 (Feta Cheese)", 30.0, "克", "可選"),
                Ingredient("新鮮歐芹碎（或香菜）", 1.0, "小把", "裝飾提香"),
                Ingredient("粗粒海鹽與黑胡椒", 1.0, "適量")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "煸香洋蔥與彩椒絲",
                    description = "平底鑄鐵鍋倒入橄欖油燒熱，下洋蔥丁與大蒜片中小火炒香約 3 分鐘，加入彩椒絲翻炒至變軟釋放清甜味。",
                    timerMinutes = 4
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "下香料與熬煮番茄濃醬",
                    description = "撒入孜然粉與煙燻紅椒粉煸炒 20 秒激發地中海香氣，倒入番茄丁與 50 毫升清水，加海鹽黑胡椒調味，中小火慢熬 5 分鐘至番茄化成濃稠紅醬。",
                    timerMinutes = 5,
                    tip = "孜然與煙燻紅椒粉是北非蛋獨特迷人香氣的核心靈魂！"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "挖窩打入雞蛋與燜熟",
                    description = "用湯匙在濃郁醬汁上挖出 3 個均勻凹窩，分別磕入整顆生雞蛋，周圍捏碎撒上菲達乳酪，轉微火蓋上鍋蓋燜 3-4 分鐘至蛋白泛白凝固而蛋黃保持完美流心。",
                    timerMinutes = 4,
                    tip = "隨時掀蓋觀察火候，蛋黃微晃即可熄火，避免蛋黃燜至全熟失去流心滋味。"
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "撒香草出鍋佐麵包",
                    description = "熄火，表面均勻撒上新鮮歐芹碎與少許現磨黑胡椒，整鍋端上餐桌，搭配烤熱酥脆的歐式酸種麵包或法棍沾食！",
                    timerMinutes = null
                )
            ),
            chefTips = listOf(
                "直接連同鑄鐵鍋端上桌能長效保溫，沾著熱騰騰的番茄蛋醬吃最過癮！"
            ),
            primaryColorHex = 0xFFD84315L,
            secondaryColorHex = 0xFFFF7043L
        ),
        Recipe(
            id = "chicken_breast_quinoa_bowl",
            title = "義式香草舒肥雞胸彩虹藜麥碗",
            subtitle = "水嫩多汁不柴！低GI、高蛋白與全方位微量營養",
            description = "健身減脂期的滿分奢華便當！精選國產清雞胸肉用橄欖油、檸檬皮屑、迷迭香與蒜碎低溫舒肥浸熟，肉質水潤軟嫩如豆腐完全告別乾柴；搭配富含完全蛋白質的三色藜麥飯、烤蜜南瓜、水煮毛豆仁與櫻桃番茄，淋上蜂蜜檸檬油醋汁，清爽無負擔又有超強飽足感。",
            category = Category.FITNESS,
            emoji = "🥗",
            prepTimeMinutes = 15,
            cookTimeMinutes = 15,
            defaultServings = 2,
            difficulty = Difficulty.EASY,
            calories = 380,
            rating = 4.8,
            reviewCount = 267,
            tags = listOf("減脂增肌", "超嫩不柴", "低GI高纖", "健康輕食"),
            ingredients = listOf(
                Ingredient("新鮮去皮雞胸肉", 300.0, "克", "切厚片"),
                Ingredient("三色熟藜麥飯", 160.0, "克", "蒸熟放涼"),
                Ingredient("日本栗子南瓜", 120.0, "克", "切薄片烤熟"),
                Ingredient("剝殼毛豆仁", 50.0, "克", "燙熟"),
                Ingredient("彩色櫻桃番茄", 8.0, "顆", "對半切"),
                Ingredient("特級初榨橄欖油", 2.0, "大匙"),
                Ingredient("新鮮迷迭香（或義式綜合香草）", 1.0, "茶匙"),
                Ingredient("新鮮檸檬汁", 1.5, "大匙"),
                Ingredient("純蜂蜜", 1.0, "茶匙"),
                Ingredient("海鹽與白胡椒粉", 1.0, "適量")
            ),
            steps = listOf(
                CookingStep(
                    stepNumber = 1,
                    title = "鹽水醃製與香草調味",
                    description = "雞胸肉厚處劃淺刀，浸泡 5% 鹽糖水 15 分鐘（使肌纖維鎖水），取出吸乾水份，抹上橄欖油、迷迭香碎、海鹽與黑胡椒。",
                    timerMinutes = 15,
                    tip = "鹽水浸泡法（Brining）是讓雞胸肉水潤爆汁、即使煎熟也不柴的物理科學秘笈！"
                ),
                CookingStep(
                    stepNumber = 2,
                    title = "嫩煎雞胸鎖住肉汁",
                    description = "平底鍋抹少許橄欖油中火燒熱，放入雞胸片，單面煎 2 分鐘轉金黃微焦，翻面煎 1 分鐘，倒入 2 大匙溫水立刻蓋上鍋蓋，轉微火利用熱蒸氣燜 3 分鐘後熄火靜置 2 分鐘。",
                    timerMinutes = 6,
                    tip = "水煎燜熟法能模擬低溫舒肥效果，肉質軟嫩多汁。"
                ),
                CookingStep(
                    stepNumber = 3,
                    title = "調配檸檬蜜汁油醋",
                    description = "小碗中混合橄欖油、檸檬汁、蜂蜜、海鹽攪打至完全乳化成金黃油醋醬。",
                    timerMinutes = 1
                ),
                CookingStep(
                    stepNumber = 4,
                    title = "彩虹碗繽紛組裝",
                    description = "大餐碗鋪底蒸好的三色藜麥，依序整齊碼上斜切片嫩雞胸、金黃烤南瓜片、碧綠毛豆仁與鮮紅小番茄，均勻淋上檸檬油醋汁享用！",
                    timerMinutes = null
                )
            ),
            chefTips = listOf(
                "可一次多備兩份分裝在玻璃保鮮盒中冷藏，作為上班族 3 天內的高蛋白健康工作便當！"
            ),
            primaryColorHex = 0xFF388E3CL,
            secondaryColorHex = 0xFF81C784L
        )
    )
}
