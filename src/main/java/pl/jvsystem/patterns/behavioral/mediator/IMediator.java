package pl.jvsystem.patterns.behavioral.mediator;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 21:20
 */
public interface IMediator {
	public void book();
	public void view();
	public void search();
	public void registerView(BtnView v);
	public void registerSearch(BtnSearch s);
	public void registerBook(BtnBook b);
	public void registerDisplay(LblDisplay d);
}
