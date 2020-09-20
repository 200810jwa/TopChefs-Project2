export class Recipe {
  id: Number;
  title: String;
  link: String;
  ingredients: String;
  thumbnailBase64: String;
  //thumbnailByteArray:Byte[]; -- Do we need this? How to implement if we do?
  rating: Number;

  constructor(
    _id: Number,
    _title: String,
    _link: String,
    _ingredients: String,
    _thumbnailBase64: String,
    _rating: Number
  ) {
    this.id = _id;
    this.title = _title;
    this.link = _link;
    this.ingredients = _ingredients;
    this.thumbnailBase64 = _thumbnailBase64;
    this.rating = _rating;
  }
}
