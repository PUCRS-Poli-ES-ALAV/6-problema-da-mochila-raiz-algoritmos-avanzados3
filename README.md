# Resultados:


## Knapsack
```
Pesos: 56, 59, 80, 64, 75, 17
Valores: 50, 50, 64, 46, 50, 05
Knapsack Brute Force | Itens: 6| Capacity: 190 | result: 150 | Interactions: 85 | Time: 31417ns
Knapsack Dynamic | Itens: 6| Capacity: 190 | result: 150 | Interactions: 1140 | Time: 283991ns




Pesos:  23, 31, 29, 44, 53, 38, 63, 85, 89, 82
Valores: 92, 57, 49, 68, 60, 43, 67, 84, 87, 72
Knapsack Brute Force | Itens: 10| Capacity: 165 | result: 309 | Interactions: 362 | Time: 98902ns
Knapsack Dynamic | Itens: 10| Capacity: 165 | result: 309 | Interactions: 1650 | Time: 2470713ns



Esse caso de teste possui mais itens, onde os itens são de peso menor quando comparado à capacidade da mochila. Nesse caso podemos ver a vantagem da programação dinamica.
Nos casos anteriores onde haviam menos itens e os pesos eram mais próximos à capacidade da mochila, a vantagem em usar programação dinamica não era evidente

Pesos: 3, 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 3, 5, 6, 7 ,8, 9, 4, 7 ,8, 9, 5, 3, 2, 1,4, 4,5,1
Valores: 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 5, 5, 6, 7 ,8, 9, 4, 7 ,8,  9, 5, 3, 2, 1,4, 4,5,1, 5
Knapsack Brute Force | Itens: 36| Capacity: 100 | result: 137 | Interactions: 101890328914 | Time: 362445101538ns
Knapsack Dynamic | Itens: 36| Capacity: 100 | result: 137 | Interactions: 3600 | Time: 340276ns
```


## Distancia Edição
```
Edit Distance Brute Force | Initial String Length: 4 | Final String Length: 3 | Cost/Result: 3 | Interactions: 119 | Time: 46933ns
Edit Distance Brute Force | Initial String Length: 10 | Final String Length: 10 | Cost/Result: 10 | Interactions: 12146179 | Time: 97754457ns
Edit Distance Brute Force | Initial String Length: 718 | Final String Length: 317 | Cost/Result, Interactions, Time: Deixei executando por muito tempo e não terminou de executar


Edit Distance Dynamic | Initial String Length: 4 | Final String Length: 3 | Cost/Result: 3 | Interactions: 19 | Time: 14409ns
Edit Distance Dynamic | Initial String Length: 10 | Final String Length: 10 | Cost/Result: 10 | Interactions: 120 | Time: 43675ns
Edit Distance Dynamic | Initial String Length: 718 | Final String Length: 317 | Cost/Result: 557 | Interactions: 228641 | Time: 31471158ns
```






# Enunciado para exercício sobre Problema da Mochila

1. Resolva o problema da mochila conforme o enuciado em sala de aula. 
   1. Ache uma solução que testa todas as combinações possíveis e seleciona a melhor, aplicando divisão-e-conquista ou não;
   1. Contabilize o número de iterações;
   1. Implemente e teste sua solução, para o caso exposto em aula e outros de mesmo porte (;-)).
1. Resolva o problema da mochila utilizando o algoritmo com programação dinâmica visto em aula, teste e contabilize o número de iterações.
1. Monte uma tabela com os resultados e número de iterações de ambas a implementações, para os casos de testes disponíveis no moodle.
```javascript
Inteiro backPackPD(Inteiro N, Inteiro C, Tupla<Inteiro, Inteiro> itens)
   N = número de produtos;
   C = capacidade real da mochila
   itens[N +1];   // (O índice 0 guarda null), Tupla com peso e valor
   maxTab[N+1][C+1];

   Inicialize com 0 toda a linha 0 e também a coluna 0;
   para i = 1 até N
      para j = 1 até C
         se item itens[i].peso <= j // se o item cabe na mochila atual
            maxTab[i][j] = Max(maxTab[i-1][j], 
                               itens[i].valor + 
                                 maxTab[i-1][j – itens[i].peso]);
         senão
            maxTab[i][j] = maxTab[i-1][j];

   retorne maxTab[N][C] // valor máximo para uma mochila de capacidade C e 		         
                        //que pode conter itens que vão do item 1 até o item N.
```
4. Resolva o problema da distância de edição conforme o enuciado em sala de aula. 
   1. Ache uma solução que testa todas as combinações possíveis e seleciona a melhor, aplicando divisão-e-conquista ou não;
   1. Contabilize o número de iterações;
   1. Implemente e teste sua solução, para (pelos menos) os caso abaixo.
5. Implemente e teste o algoritmo de programação dinâmica para Distância de Edição. Contabilize o número de iterações. Utilize o mesmo repositório dos exercícios anteriores sobre programação dinâmica, como o mesmo grupo de trabalho. 
6. Complete a tabela com os resultados e número de iterações desta implementação, para os strings abaixo:
```
s1 = "Casablanca"
s2 = "Portentoso"

s1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
				"simplify the build processes in the Jakarta Turbine project. There were several" + 
				" projects, each with their own Ant build files, that were all slightly different." +
				"JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
				"definition of what the project consisted of, an easy way to publish project information" +
				"and a way to share JARs across several projects. The result is a tool that can now be" +
				"used for building and managing any Java-based project. We hope that we have created " +
				"something that will make the day-to-day work of Java developers easier and generally help " +
				"with the comprehension of any Java-based project.";
s2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
				"kernels. They are universally applicable in any machine learning algorithm. Why you might" +
				"ask? I am going to try to answer this question in this article." + 
			        "Go to the profile of Marin Vlastelica Pogančić" + 
			        "Marin Vlastelica Pogančić Jun";
```
7. Resolva o problema da distância de edição utilizando o algoritmo com programação dinâmica visto em aula, teste e contabilize o número de iterações.
8. Monte uma tabela com os resultados e número de iterações de ambas a implementações, para, pelo menos, os casos de testes disponíveis acima.
```
// Assumindo os Custos: Remoção=R, Inserção=I , Substituição=S e Match=M=0;

inteiro distEdProgDina(string A, String B)
	m = tamanho(A);
	n = tamanho(B);
	matriz[0][0] = 0;
	Para i = 1 até m
	   matriz[i][0] = matriz[i-1][0] + 1  // soma uma I;
	Para j = 1 até n
	   matriz[0][j] = matriz[0][j-1] + 1  // Soma uma R;
	Para i = 1 até m
	   Para j = 1 até n
	      Se A[i] == B[j]
		 custoExtra = 0 //Operação M;
	      Senão
		 custoExtra = 1 //Operação S;
	      matriz[i][j] = Mínimo(matriz[i-1][j] +1, matriz[i][j-1] +1, 
				    matriz[i-1][j-1] + custoExtra];
	devolva matriz[m][n];
```
