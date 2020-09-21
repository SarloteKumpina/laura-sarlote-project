package com.accenture.prebootcamp.cowsandbulls;

public class CowsAndBullsGame {
/*
BURN AFTER READING

*Klau, es te nedaudz paštukoju par to, kā būvēt sākumu un mans piedāvājums ir šāds.
Varēsim izrunāt lekcijas laikā, ja kaut kas ir nesaprotams... Protams, varam mainīt, ja vēlies savādāk!
*Nomainīju nosaukumu no "UserGuess" uz "Utils", jo tajā klasē principā glabāsies visas metodes utt utt
*Un vēl viena lieta - man šķiet, ka tur vajag tomēr ciparus ģenerēt no 1-9, ne 0-9. Tāpēc piedāvāju ģenerētos
ciparus salīdzināt ar String, kurā ir jau ielikta arī tā nulle (tas tā, lai, ja random uzģenerē 0, tad
ģenerē citu skaitli).. Pagaidām atstāju "public" un uzrakstīju to "for" ciklu drukāšanai, lai redzētu, kā strādā ģenerators.
 */

    public static void main(String[] args) {
        int[] randomNumber = Utils.generateNumber();

        for (int i = 0; i < randomNumber.length; i++) {
            System.out.print(randomNumber[i] + " ");
        }
    }
}
