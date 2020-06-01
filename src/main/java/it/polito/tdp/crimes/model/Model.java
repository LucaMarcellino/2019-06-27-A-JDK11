package it.polito.tdp.crimes.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	private Event e;
	private EventsDao dao;
	private List<Event> eventi ;
	private Graph<String,DefaultWeightedEdge> grafo;
	
	public Model() {
		this.dao= new EventsDao();
		this.eventi= new ArrayList<Event>(dao.listAllEvents());
	}
	
	public List<Event> getEventi(){
		return eventi;
	}
	
	public void creaGrafo(String id,int anno) {
		this.grafo= new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo,dao.getVertex(id, anno));
		
	}
	
	
}
