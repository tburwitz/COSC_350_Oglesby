PurchasedPaintingReport
{
  private InventoryPainting[] paintingsBoughtInLastYear;
  private double maxAndActualRatio;
  //Desc: Creates an object of type PurchasedPaintingReport
  //Post: paintingsBoughtInLastYear initialized with the paintings purchased one year
  //	  back from today. calcMaxAndActualRatio is set to the ratio of maximum purchase
  //	  price to acutal purchase price. (max/actual)
  public purchasedPaintingReport()
  {
	paintingsBoughtInLastYear=getPaintingsBoughtInLastYear()
	calcMaxAndActualRatio()
  }
  public InventoryPainting[] getBoughtPaintings()
  {
	return getPaintingsboughtInLastYear()
  }
  //Desc: Returns the maxAndActualRatio of this object.
  //	  maxAnd ActualRatio defined to be maximum purchase price/actual purchase price
  public double getMaxAndActualRatio()
  {
	return maxAndActualRatio
  }
  //Desc: Calculates the ratio of maximum purchase price to actual purchase price 
  //	  for all paintings bought in the last year.
  //Post: The ratio saved into maxAndaActualRatio of this object.
  private static void calcMaxAndActualRatio()
  {
	int count=0
	for(int i=0;i<paintingsboughtInLastYear
	{
		InventoryPainting painting=iter.next()
		maxAndAcutalRatio+=painting.getMaxPurchasePrice()/painting.getActualPurchasePrice()
		count++
	}
	maxAndAcutalRatio=maxAndAcutalRatio/count
  }
  //Desc: Finds all paintings that have been bought in the last year. 
  //Return: An array of InventoryPainting Objects
  private static InventoryPainting[] getPaintingsBoughtInLastYear()
  {
	Date d=new Date()
	d.setYear(d.getYear()+1)
	return handleInventoryRecords.retrieveInventory("SQL statement")
  }
}
