package model.entitys;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="showID")
	private Long id;
	
	@Column(name="data_do_show", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_id")
	private Local local_do_show;
	
	@ManyToMany
	@JoinTable(name="bandas_do_show", joinColumns = @JoinColumn(name="ShowID")
	,inverseJoinColumns = @JoinColumn(name="bandaID"))
	private List<Banda> bandas;
	
	public Show() {
		
	}
	
	public Show(Long id, Date data, Local local_do_show) {
		super();
		this.id = id;
		this.data = data;
		this.local_do_show = local_do_show;
	}

	public Show(Long id, Date data, Local local_do_show, List<Banda> bandas) {
		super();
		this.id = id;
		this.data = data;
		this.local_do_show = local_do_show;
		this.bandas = bandas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Local getLocal_do_show() {
		return local_do_show;
	}

	public void setLocal_do_show(Local local_do_show) {
		this.local_do_show = local_do_show;
	}

	public List<Banda> getBandas() {
		return bandas;
	}

	public void setBandas(List<Banda> bandas) {
		this.bandas = bandas;
	}

	
	
}
