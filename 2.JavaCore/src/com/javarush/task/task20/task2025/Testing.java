package com.javarush.task.task20.task2025;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Testing {
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407,
    // 1634, 8208, 9474, 54 748, 92 727, 93 084,
    // 548 834, 1 741 725, 4 210 818, 9 800 817, 9 926 315,
    // 24 678 050, 24 678 051, 88 593 477,
    // 146 511 208, 472 335 975, 534 494 836, 912 985 153,
    // 4 679 307 774.
    @Test
    public void test100() {
        assertArrayEquals(Solution.getNumbers(0), new long[0]);
        assertArrayEquals(Solution.getNumbers(1), new long[0]);
        assertArrayEquals(Solution.getNumbers(-1), new long[0]);
        assertArrayEquals(Solution.getNumbers(7), new long[]{1L, 2L, 3L, 4L, 5L, 6L});
        assertArrayEquals(Solution.getNumbers(10), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L});
        assertArrayEquals(Solution.getNumbers(88), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L});
        assertArrayEquals(Solution.getNumbers(100), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L});
        assertArrayEquals(Solution.getNumbers(300), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L});
        assertArrayEquals(Solution.getNumbers(407), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L});
        assertArrayEquals(Solution.getNumbers(1000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L});
        assertArrayEquals(Solution.getNumbers(100000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                1634L, 8208L, 9474L, 54748L, 92727L, 93084L});
        assertArrayEquals(Solution.getNumbers(100_000_000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                24678050L, 24678051L, 88593477L});
        assertArrayEquals(Solution.getNumbers(1_000_000_000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                24678050L, 24678051L, 88593477L, 146511208L, 472335975L, 534494836L, 912985153L});
        assertArrayEquals(Solution.getNumbers(Long.MAX_VALUE), new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474,
                54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836,
                912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L,
                94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
                1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L
        });
    }
}


//1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 498128791164624869L, 4929273885928088826L

//1
//2
//3
//4
//5
//6
//7
//8
//9
//( 2 )
//( 3 )
//153
//370
//371
//407
//( 4 )
//1634
//8208
//9474
//( 5 )
//54748
//92727
//93084
//( 6 )
//548834
//( 7 )
//1741725
//4210818
//9800817
//9926315
//( 8 )
//24678050
//24678051
//88593477
//( 9 )
//146511208
//472335975
//534494836
//912985153
//( 10 )
//4679307774
//( 11 )
//32164049650
//32164049651
//40028394225
//42678290603
//44708635679
//49388550606
//82693916578
//94204591914
//( 12 )
//( 13 )
//( 14 )
//28116440335967
//( 15 )
//( 16 )
//4338281769391370
//4338281769391371
//( 17 )
//21897142587612075
//35641594208964132
//35875699062250035
//( 18 )
//( 19 )
//1517841543307505039
//3289582984443187032
//4498128791164624869
//4929273885928088826
//( 20 )
//63105425988599693916
//( 21 )
//128468643043731391252
//449177399146038697307
//( 22 )
//( 23 )
//21887696841122916288858
//27879694893054074471405
//27907865009977052567814
//28361281321319229463398
//35452590104031691935943
//( 24 )
//174088005938065293023722
//188451485447897896036875
//239313664430041569350093
//( 25 )
//1550475334214501539088894
//1553242162893771850669378
//3706907995955475988644380
//3706907995955475988644381
//4422095118095899619457938
//( 26 )
//( 27 )
//121204998563613372405438066
//121270696006801314328439376
//128851796696487777842012787
//174650464499531377631639254
//177265453171792792366489765
//( 28 )
//( 29 )
//14607640612971980372614873089
//19008174136254279995012734740
//19008174136254279995012734741
//23866716435523975980390369295
//( 30 )
//( 31 )
//1145037275765491025924292050346
//1927890457142960697580636236639
//2309092682616190307509695338915
//( 32 )
//17333509997782249308725103962772
//( 33 )
//186709961001538790100634132976990
//186709961001538790100634132976991
//( 34 )
//1122763285329372541592822900204593
//( 35 )
//12639369517103790328947807201478392
//12679937780272278566303885594196922
//( 36 )
//( 37 )
//1219167219625434121569735803609966019
//( 38 )
//12815792078366059955099770545296129367
//( 39 )
//115132219018763992565095597973971522400
//115132219018763992565095597973971522401