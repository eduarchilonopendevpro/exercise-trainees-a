package com.opendevpro.model;

import java.util.Objects;

public class Reporte {
	private Integer month;
	private Integer year;
	private Double ventasTotales;
	private Integer cantidadAutosVendidos;

	public Reporte(Integer month, Integer year, Double ventasTotales, Integer cantidadAutosVendidos) {
		this.month = month;
		this.year = year;
		this.ventasTotales = ventasTotales;
		this.cantidadAutosVendidos = cantidadAutosVendidos;
	}

	public Reporte(){}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getVentasTotales() {
		return ventasTotales;
	}

	public void setVentasTotales(Double ventasTotales) {
		this.ventasTotales = ventasTotales;
	}

	public Integer getCantidadAutosVendidos() {
		return cantidadAutosVendidos;
	}

	public void setCantidadAutosVendidos(Integer cantidadAutosVendidos) {
		this.cantidadAutosVendidos = cantidadAutosVendidos;
	}

	@Override
	public String toString() {
		return "Reporte{" +
				"month=" + month +
				", year=" + year +
				", ventasTotales=" + ventasTotales +
				", cantidadAutosVendidos=" + cantidadAutosVendidos +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reporte reporte = (Reporte) o;
		return Objects.equals(month, reporte.month) && Objects.equals(year, reporte.year);
	}

	@Override
	public int hashCode() {
		return Objects.hash(month, year);
	}
}
