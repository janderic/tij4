package com.gmail.janderic.kuk.tij4.chapter17;

import java.util.*;

/**
 * @Types Practice13
 * @Description 实现单词计数器，依赖Practice12
 * @author juchen
 * @date 2016年11月14日 上午11:17:17
 */
public class Practice13 {
    static final String TEXT_CONTENT = "The eruption occurred in 1257, probably around September 1257.[10] Based on the deposits of the eruption, it commenced with a first phreatic stage which deposited 3 centimetres (1.2 in) of ash over 400 square kilometres (150 sq mi) of northwest Lombok. In the subsequent first magmatic stage, a lithic rich pumice ash fell, reaching a thickness of 8 centimetres (3.1 in) both upwind on East Lombok and on Bali.[6] Subsequently, various phases of lapilli and ash falls occurred, as well as pyroclastic flows which were partially confined within the valleys on Samalas's western flank. Some ash deposits were eroded by the pyroclastic flows, generating furrow structures. Pyroclastic flows even crossed the Bali Sea, reaching the Gili Islands. This eruption phase was probably phreatomagmatic, the deposits show evidence of interaction with water. Three pumice fallouts subsequently fell, reaching the widest extend of all deposits formed by the eruption.[11] These pumices fell as far as Sumbawa in the east, where they are up to 7 centimetres (2.8 in) thick. The formation of these pumices was followed by another stage of pyroclastic flow activity, probably caused by the collapse of the eruption column and the beginning formation of the caldera, where the conditions changed from column-generating to fountain-generating. These pyroclastic flows were deflected by older volcanic edifices and incinerated the vegetation. Interaction between these flows and the air triggered the formation of additional eruption clouds and secondary pyroclastic flows. Where the flows entered the sea north and east of Lombok, steam explosions generated pumice cones on the beach and additional secondary pyroclastic flows.[12] These pyroclastic flows have an on-land volume of 29 cubic kilometres (7.0 cu mi),[13] and reach thicknesses of 35 metres (115 ft) as far as 25 kilometres (16 mi) away from Samalas.[14] These phases are also known as P1 (phreatic and first magmatic phase), P2 (phreatomagmatic with pyroclastic flows), P3 (plinian) and P4 (pyroclastic flows).[15] The whole eruption lasted between 12 and 15 hours, not accounting for the first emission of pyroclastic flows (P2).[16] Tephra from the eruption fell as far as Java, forming part of the so-called Muntilan Tephras.[12] In Lake Logung on Java it is 3 centimetres (1.2 in) thick. On Agung volcano on Bali, the deposits reach thicknesses of 12–17 centimetres (4.7–6.7 in). Most of the tephra was deposited west-southwest of Samalas.[17] Considering the thickness of Samalas tephras found at Mount Merapi, the total volume may have reached 32–39 cubic kilometres (7.7–9.4 cu mi).[18] The dispersal index of the eruption reached 7,500 square kilometres (2,900 sq mi) during the first stage and of 110,500 square kilometres (42,700 sq mi) during the third stage, implying a Plinian eruption and an ultraplinian eruption respectively.[19] The eruption column by this eruption reached a height of 39–40 kilometres (24–25 mi) at windspeeds of 10 metres per second (33 ft/s) during the first stage (P1),[20] and 43–38 kilometres (27–24 mi) between (P3) the two stages with emission of pyroclastic flows.[16] The eruption column from this eruption was high enough that SO 2 in it and its S isotope ratio was influenced by photolysis at high altitudes.[21] Various volumes have been estimated for the various stages of the Samalas eruption. The first stage reached a volume of 12.6–13.4 cubic kilometres (3.0–3.2 cu mi). The second phreatomagmatic phase has been estimated to have had a volume of 0.9–3.5 square kilometres (0.35–1.35 sq mi).[22] The total dense rock equivalent volume of the whole eruption is at least 40 cubic kilometres (9.6 cu mi).[19] The material erupted by the volcano had a temperature of about 1,000 °C (1,830 °F).[4] Compositionally, the material was of trachydacitic composition, containing amphibole, apatite, clinopyroxene, iron sulfide, orthopyroxene, plagioclase and titanomagnetite. It formed out of basaltic magma by fractional crystallization.[23] The eruption has a volcanic explosivity index of 7,[24] making it one of the largest eruptions of the Holocene.[25] It was even stronger than the eruptions of Krakatau 1883 and Tambora 1815.[26] Other eruptions of comparable intensity are the Kurile lake eruption in the 7th millennium BC, the Mount Mazama eruption in the 6th millennium, the Minoan eruption and the Tierra Blanca Joven eruption of Ilopango in the 6th century.[25] Pumice falls with a fine graining and colour of cream from the Samalas eruption form an useful tephrochronological wikt:marker on Bali.[27] Tephra from the volcano was found in ice cores as far as 13,500 kilometres (8,400 mi) away from Samalas.[28] The eruption left the Sengara Anak caldera, which has a diametre of 6–7 kilometres (3.7–4.3 mi).[7] Within its 700–2,800 metres (2,300–9,200 ft) high walls a 200 metres (660 ft) deep crater lake formed. The Barujari cone rises 320 metres (1,050 ft) above the water of the lake and has had 15 eruptions since 1847.[5] It is possible that a crater lake already existed on Samalas before the eruption and supplied the phreatomagmatic phase thereof with 0.1–0.3 cubic kilometres (0.024–0.072 cu mi) of water; alternatively the water came from aquifers.[29] A collapse structure cuts into Rinjani's slopes facing the Samalas caldera.[4] The eruption that formed the caldera was first recognized in 2003 and in 2004 a volume of 10 cubic kilometres (2.4 cu mi) was attributed to this eruption.[6] Early research considered that the caldera-forming eruption occurred between 1210–1300. In 2013, Lavigne suggested that the eruption occurred in May–October 1257, resulting in the climate changes of 1258.[7]";
    
    private static String[] splitTxt() {
	String lowerStr = TEXT_CONTENT.toLowerCase();
	return lowerStr.split(" ");
    }
    
    public static void main(String[] args) {
	Practice12<String, Integer> map = new Practice12(HashMap.class);
	long st = System.currentTimeMillis();
	String[] txts = splitTxt();
	for (String eachWord : txts) {
	    Integer times = map.get(eachWord);
	    if(times == null) {
		map.put(eachWord, 1);
	    } else {
		map.put(eachWord, times + 1);
	    }
	}
	System.out.println(map);
	long et = System.currentTimeMillis();
	
	System.out.println(String.format("执行时长：%dms", (et - st)));
    }
}
