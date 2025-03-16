package viewer;

import controller.ICtrl;

public interface IViewer {
	public abstract ICtrl getCtrl();
	public abstract void  notificar(String textoDeNotificacao);
	public abstract void  finalizar();
	public abstract void  apresentar();
}
