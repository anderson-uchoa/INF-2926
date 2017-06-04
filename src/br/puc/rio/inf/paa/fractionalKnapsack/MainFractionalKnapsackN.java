package br.puc.rio.inf.paa.fractionalKnapsack;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import br.puc.rio.inf.paa.fractionalKnapsack.reader.FractionalKnapsackReader;
import br.puc.rio.inf.paa.utils.CsvWriter;

public class MainFractionalKnapsackN {


	public static void main(String[] args) {

		String nameCSV = "nameCSVMainFractionalKnapsackN.csv";

		CsvWriter writer = new CsvWriter(nameCSV, ',', Charset.forName("ISO-8859-1"));

		FractionalKnapsackReader knapsackReader = new FractionalKnapsackReader();

		List<FractionalKnapsack> fractionalKnapsacks = knapsackReader.createAllInstances();

		int count = 0;
		int numInstance = 0;

		int timeout = 5;
		double temp_final = 0.0;
		double durationEnd = 0.0;
		double ctTime = 0.0;
		double cpuTime = 0.0;

		try {
			writer.write("N");
			writer.write("CT");
			writer.write("CPU");
			writer.write("CT/CPU");

			writer.endRecord();

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < fractionalKnapsacks.size(); i++) {
			FractionalKnapsackN knapsackN = new FractionalKnapsackN();
			Map<Item, Double> map = null;
			double temp_inicio = System.nanoTime();

			while (durationEnd <= timeout) {
				map = knapsackN.knapsack(fractionalKnapsacks.get(i));
				temp_final = System.nanoTime();
				durationEnd = temp_final - temp_inicio;
				count++;
			}

			numInstance++;
			try {

//				ctTime = fractionalKnapsacks.get(i).items.length
//						* Utils.logBase2(fractionalKnapsacks.get(i).items.length);


				ctTime = fractionalKnapsacks.get(i).items.length;

				
				cpuTime = (durationEnd / count);

				cpuTime = cpuTime / 100;

				writer.write(String.valueOf(fractionalKnapsacks.get(i).items.length));

				writer.write(new BigDecimal(ctTime, MathContext.DECIMAL64).toString());

				writer.write(new BigDecimal(cpuTime, MathContext.DECIMAL64).toString());

				writer.write(new BigDecimal((ctTime / cpuTime), MathContext.DECIMAL64).toString());

				writer.endRecord();

			} catch (IOException e) {
				e.printStackTrace();
			}

			// System.out.println("No Instance: " + numInstance);
			// System.out.println(instance.name);
			// System.out.println("N: " + instance.numVertex + " x " + "M: " +
			// instance.numEdges);
			// System.out.println("Quantidade de vezes: " + count);
			// System.out.println("Tempo medio: " + (durationEnd / count));
			// System.out.println("CT: " + ctTime);
			// System.out.println();

			count = 0;
			durationEnd = 0;

		}
		writer.close();
	}
	// System.out.println("#####################" + "INSTANCIA - " + i);
	// System.out.println("##" + "CAPACIDADE - " +
	// fractionalKnapsacks.get(i).capacity);

	// map.entrySet().forEach( entry-> {
	// System.out.println(entry.getKey().id + " " + entry.getValue());
	// });
	// break;
	// }
	//

	// }
}

	
