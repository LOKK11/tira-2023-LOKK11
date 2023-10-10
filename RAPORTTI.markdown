# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Tehtävän tekemisessä opin/kertasin, miten javalla iteroidaan taulukoiden läpi ja miten niitä järjestellään ilman ArrayList:ia.

Toteuttamani lajittelualgoritmin aikakompleksisuusluokka on O(n^2).

Toteuttamani reverse-algoritmin aikakompleksisuusluokka on O(n).

Kannattaa kääntää sen järjestys, koska kääntämisalgoritmin aikakompleksisuusluokka on lineaarinen n ja lajittelualgoritmin eksponentiaalinen n^2. Tällä on suuri merkitys erityisesti suuria taulukoita lajitellessa.

## 02-TASK

Suoritin askeleen 3 testin 2 kertaa. Vasemmalla kuvassa on ensimmäisen testin tulokset fill ja search aikojen suhteista n kokoon. Oikealla on otettu kahden testin keskiarvot jokaiselle arvolle ja asetettu ne taulukkon n kanssa.
![Taulukko](taulukko_task2.png)
Toisen testin tulokset
```
n		Fill	Search	Total
500		25		1415	1440
1000	21		404		425
1500	11		491		502
2000	14		659		673
2500	24		704		728
3000	31		353		384
3500	35		630		665
4000	48		216		264
4500	61		659		720
5000	73		141		214
5500	90		272		362
6000	104		374		478
6500	122		318		440
7000	141		324		465
7500	175		1468	1643
8000	193		393		586
8500	209		416		625
9000	237		414		651
9500	263		477		740
10000	297		469		766
10500	359		547		906
11000	411		476		887
11500	399		569		968
12000	453		1065	1518
12500	586		632		1218
13000	654		611		1265
13500	672		665		1337
14000	611		604		1215
14500	669		664		1333
15000	789		853		1642
15500	635		426		1061
16000	837		783		1620
16500	903		903		1806
17000	968		837		1805
17500	1091	929		2020
18000	1383	881		2264
18500	1374	922		2296
19000	1479	932		2411
19500	1512	1015	2527
20000	1494	1055	2549
20500	1582	1250	2832
21000	1754	1807	3561
21500	1799	2627	4426
22000	1911	1226	3137
22500	2178	1287	3465
23000	2374	1312	3686
23500	1400	673		2073
24000	2540	2232	4772
24500	2566	2717	5283
25000	2847	1661	4508
25500	3026	1915	4941
26000	3101	3227	6328
26500	3386	1644	5030
27000	3536	3151	6687
27500	3677	3091	6768
28000	3868	1871	5739
28500	4143	1936	6079
29000	4259	3278	7537
29500	2834	1278	4112
30000	4738	2350	7088
30500	4907	2265	7172
31000	5176	3515	8691
31500	6177	4425	10602
32000	6293	2682	8975
```
Käyristä näyttäisi, että molempien aikojen kasvavan eksponentiaalisesti n kasvaessa. SimpleContainen.add -algoritmi ei sisällä sisäkkäisiä looppeja, vaan pelkkiä yksittäisiä looppeja, joten sen aikakompleksisuusluokka on O(n). Mutta, kun add-algoritmia kutsutaan toisesta loopista LinearFindTest.fillContainer:ssa n kertaa on koko lisäyksen aikakompleksisuusluokka O(n^2). Siksi kulunut aika kasvaa eksponentiaalisesti.
Totetuttamani hakualgoritmit sisältävät kaikki vain yhden for loopin, joten niiden kaikkien aikakompleksisuusluokka on O(n). Myös hakualgoritmeja kutsutaan testissä ulommasta loopista, joten koko haun aikakompleksisuusluokka on myös O(n^2). Siksi myös se vaikuttaisi kasvavan eksponentiaalisesti.

Tehtävää tehdessä muistui mieleen Javan luokkien ja rajapintojen toiminta. Vaikeaa oli juuri käytännön toteutus, kun Javan syntaksi ei ole hyvin muistissa. Helppoa oli itse koodin kirjoittaminen. For silmukat oli helppo toteuttaa.

Käytetään 10 000 koodarin tiedostoa.
Lajittelu on nopeaa (~1ms) silloin, kun vaihdetaan järjestys laskevasta nousevaan tai toisin päin. Hitaampaa (~700ms) silloin, kun järjestetään taulukko uudestaan eri perusteella eli koko nimestä koodarimeen tai toisin päin. Nimien vaihtaminen laskevasta nousevaan on nopeaa, koska reverse-algoritmin aikakompleksisuusluokka on O(n), eli sen suoritusaika kasvaa lineaarisesti tiedoston koon kasvaessa. Uudelleen lajittelu on taas hitaampaa, koska siinä käytetään toteuttamaani insertionSort-algoritmia, jonka aikakompleksisuusluokka on O(n^2). Näin ollen siis lajitteluun kuluva aika kasvaa eksponentiaalisesti tiedoston koon kasvaessa.

Yleisesti, jos on taulukko valmiiksi lajiteltuna, niin kannattaa alkioiden järjestys vaihtaa päinvastaiseksi aina reverse-algoritmilla juuri sen takia, että sen aikakompleksisuusluokka on O(n), eli se toimii nopeasti, vaikka tiedostokoko olisi suuri.

Toteuttamiani hakualgoritmeja kutsutaan lineaarisiksi, koska ne sisältävät kaikki vain yhden for silmukan, joka käydään läpi maksimissaan n kertaa. Hakualgoritmit eivät siis sisällä sisäkkäisiä looppeja. Algoritmien aikakompleksisuusluokka on siis O(n).

## 03-TASK
![Graafit_testeistä](graafit_task_3.png)
```
n		Fill	Sort	Search	Total
500		2		0		1833	1835
1000	12		8		121		141
1500	10		20		37		67
2000	20		45		34		99
2500	20		20		69		109
3000	29		33		41		103
3500	33		48		37		118
4000	50		40		42		132
4500	60		64		34		158
5000	63		70		34		167
5500	90		86		35		211
6000	110		106		55		271
6500	120		130		66		316
7000	136		167		30		333
7500	160		171		32		363
8000	184		199		53		436
8500	210		226		58		494
9000	257		277		27		561
9500	256		285		27		568
10000	344		341		69		754
10500	341		359		22		722
11000	339		422		21		782
11500	361		425		21		807
12000	405		545		44		994
12500	571		529		86		1186
13000	506		615		20		1141
13500	543		706		24		1273
14000	702		668		20		1390
14500	868		816		20		1704
15000	762		812		20		1594
15500	728		901		37		1666
16000	954		887		20		1861
16500	832		941		20		1793
17000	892		1085	26		2003
17500	944		1085	21		2050
18000	1013	1169	21		2203
18500	1162	1227	23		2412
19000	1131	1328	21		2480
19500	1309	1378	24		2711
20000	990		1299	22		2311
20500	1458	1546	24		3028
21000	1487	1705	22		3214
21500	1549	1653	21		3223
22000	1760	1773	26		3559
22500	1705	1959	21		3685
23000	1834	2005	22		3861
23500	2138	2080	25		4243
24000	2139	2079	22		4240
24500	2091	2150	28		4269
25000	2076	2270	22		4368
25500	2198	2371	24		4593
26000	2318	2473	23		4814
26500	1535	1952	36		3523
27000	2678	2668	26		5372
27500	2794	2837	26		5657
28000	2877	2994	23		5894
28500	2987	3100	24		6111
29000	3244	3139	26		6409
29500	3386	3428	23		6837
30000	3461	3550	25		7036
30500	3661	3634	38		7333
31000	3831	3789	31		7651
31500	4002	3957	26		7985
32000	3372	3769	24		7165
```

Tein graafit vain nousevan järjestyksen testien tuloksista, koska laskevan järjestyksen testeistä tuli lähes samat arvot. Graafeista huomataan, että hakuun kulunut aika on pieni myös isoilla n arvoilla toisin kuin viime tehtävässä käytetyllä lineaarisella hakualgoritmilla.

Tehdään testejä 50 000 koodarin tiedostolla

Översti haku kesti 60ms
Översti Avani Thierry fast search kesti 0ms
Tuomala haku kesti 30ms
Tuomala McLay Sajjad fast search kesti 0ms
Liitiä haku kesti 20ms
Liitiä Bertie Otto fast search kesti 0ms
Häkki haku kesti 10ms
Häkki Jiao Joynul fast search kesti 0ms
Aalo haku kesti 0ms
Aalo Dalton Cormack fast search kesti 0ms

Huomataan, että kun mennään aakkosissa lähemmäs loppupäätä, lineaarisen haun aika kasvaa suurin piirtein lineaarisesti. Tämä johtuu siitä, että lineaarinen hakualgoritmi käy jokaisen nimen läpi ja palauttaa lopulta oikean. Lineaarisen haun aikakopleksisuusluokka on O(n).

Nopea haku binäärihaulla taas kestää sijainnista riippumatta aina lähes yhtä kauan, ja huomattavasti vähemmän aikaa, kuin lineaarinen haku loppupäässä. Binäärihaku ei käy jokaista listan alkiota läpi, vaan jakaa listan aina kahteen osaan. Siksi binäärihaku toimii nopeasti myös isoilla tiedostoilla. Binäärihaun aikakopleksisuusluokka on O(log(n)). Binäärihakua voi ja kannattaa siis aina käyttää, kun halutaan etsiä jotain valmiiksi järjestetystä listasta.

Suoritin binäärihaun myös rekursiivisena binarySearchR. Ilman vertailuoliota ja sen kanssa.

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK