package gov.iti.jets.api.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.repo.Entities.ProductEntity;
import gov.iti.jets.repo.Impl.ProductRepoImpl;
import gov.iti.jets.repo.ProductRepo;
import gov.iti.jets.repo.mapper.ProductMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductsController {

  ProductRepo productRepo = ProductRepoImpl.getInstance();

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productList = new ArrayList<>();
        for(ProductEntity productEntity : productRepo.findAllProducts() ){
            productList.add(ProductMapper.instance.productEntityToDto(productEntity));
        }
        return productList;

    }





    @GET
    @Path("{id}")
    public ProductDto getProductById(@PathParam("id") long id) {
        //marwa
        ProductDto productDto = ProductMapper.instance.productEntityToDto(productRepo.findProductById(id));
        System.out.println(productDto);
        return productDto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductDto createProduct(ProductDto product) {
        ProductDto addedProduct = ProductMapper.instance.productEntityToDto(
                productRepo.saveProduct(ProductMapper.instance.productDtoToEntity(product)));
        return addedProduct;
    }


    @GET
    @Path("categories/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ProductDto> getAllProductsByCategoryId(@PathParam("id") int id) {
        List<ProductDto> productList = new ArrayList<>();
        for(ProductEntity productEntity : productRepo.findAllProductByCategoryId(id) ){
            productList.add(ProductMapper.instance.productEntityToDto(productEntity));
        }
        return productList;

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("productName")
    public List <ProductDto> getProductByName(@QueryParam("name") String productName) {
        List<ProductDto> productList = new ArrayList<>();
        for(ProductEntity productEntity : productRepo.findProductByName(productName) ){
            productList.add(ProductMapper.instance.productEntityToDto(productEntity));
        }
       return productList;


   }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("productPrice")
    public List <ProductDto> getProductByPrice(@QueryParam("price")double productPrice) {
        List<ProductDto> productList = new ArrayList<>();
        for(ProductEntity productEntity : productRepo.findProductByPrice(productPrice) ){
            productList.add(ProductMapper.instance.productEntityToDto(productEntity));
        }
        return productList;


    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductDto editProduct(ProductDto product) {
        ProductDto updatedProduct = ProductMapper.instance.productEntityToDto(
                productRepo.updateProduct( ProductMapper.instance.productDtoToEntity(product)));
        return updatedProduct;
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteProduct(@PathParam("id") long id){
        boolean deleted = productRepo.deleteProduct(id);
        return deleted;
    }
}