package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
@Service
public class VacantesServiceImpl implements IVacantesService{

	@Override
	public ArrayList<Vacante> buscarTodas() {
		ArrayList<Vacante> listVacante=new ArrayList<Vacante>();
		Vacante vacante=new Vacante();
		vacante.setId(1);
		vacante.setNombre("Licenciado en contabilidad");
		vacante.setDescripcion("Para realizar contabilidad de la empresa");
		vacante.setSalario(1234.00);
		vacante.setEstatus(true);
		vacante.setDestacado(false);
		vacante.setEmpresa("scotia.ico");
		Vacante vacante1=new Vacante();
		vacante1.setId(2);
		vacante1.setNombre("Ingeniero en sistemas");
		vacante1.setDescripcion("programas");
		vacante1.setSalario(10000.00);
		vacante1.setEstatus(false);
		vacante1.setDestacado(true);
		vacante1.setEmpresa("inbursa.jpeg");
		Vacante vacante2=new Vacante();
		vacante2.setId(3);
		vacante2.setNombre("Encargado de limpieza");
		vacante2.setDescripcion("Realizar la limpieza");
		vacante2.setSalario(6000);
		vacante2.setEstatus(true);
		vacante2.setDestacado(false);
		vacante2.setEmpresa("ViveIndice.png");
		listVacante.add(vacante);
		listVacante.add(vacante1);
		listVacante.add(vacante2);
		
		return listVacante;
	}

	@Override
	public Vacante buscarXId(int id) {
		System.out.println("Buscaremos por id "+id);
		Vacante vacante=new Vacante();
		vacante.setId(1);
		vacante.setNombre("Licenciado en contabilidad");
		vacante.setDescripcion("Para realizar contabilidad de la empresa");
		vacante.setSalario(1234.00);
		vacante.setEstatus(true);
		vacante.setDestacado(false);
		vacante.setEmpresa("scotia.ico");
		return vacante;
	}

}
