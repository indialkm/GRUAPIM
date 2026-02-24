package b_07_exe_05_agrupandoAlunodPorNota;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import b_07_exe_05_agrupandoAlunodPorNota.model.Aluno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Aluno> listaAlunos = new ArrayList<>();
		
		listaAlunos.add(new Aluno("Ana", 8.5));
        listaAlunos.add(new Aluno("Bruno", 6.0));
        listaAlunos.add(new Aluno("Carlos", 4.5));
        listaAlunos.add(new Aluno("Caique", 5.5));
        listaAlunos.add(new Aluno("Luisa", 9.5));
        
        
        Map<String, List<Aluno>> grupos = listaAlunos.stream()
                .collect(Collectors.groupingBy(aluno -> {
                    if (aluno.getNota() >= 7) return "Aprovados";
                    if (aluno.getNota() >= 5) return "Recuperação";
                    return "Reprovados";
                }));
        
        System.out.println(grupos);
		
	}

}
