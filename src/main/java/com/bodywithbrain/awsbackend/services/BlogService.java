package com.bodywithbrain.awsbackend.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.bodywithbrain.awsbackend.model.BwbBlog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogService {

    private static final Logger LOGGER = LogManager.getLogger();
    Table blogTable;
    DynamoDBMapper dynamoDBMapper;

    @Inject
    public BlogService(Table blogTable, DynamoDBMapper dynamoDBMapper) {
        this.blogTable = blogTable;
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<BwbBlog> saveBlog(BwbBlog bwbBlog) {
        dynamoDBMapper.save(bwbBlog);
        return getAllBlogs();
    }

    public List<BwbBlog> getBlogs(String createdBy){
        if(createdBy.equalsIgnoreCase("all")){
            return getAllBlogs();
        }else {
            final BwbBlog gsiKeyObj = new BwbBlog();
            gsiKeyObj.setCreatedBy(createdBy);
            final DynamoDBQueryExpression<BwbBlog> queryExpression =
                    new DynamoDBQueryExpression<>();
            queryExpression.setHashKeyValues(gsiKeyObj);
            queryExpression.setIndexName("usergsi");
            queryExpression.setConsistentRead(false);   // cannot use consistent read on GSI
            return  dynamoDBMapper.query(BwbBlog.class, queryExpression);
        }
    }

    public  List<BwbBlog> getAllBlogs(){
        List<BwbBlog> allBlogs = dynamoDBMapper.scan(BwbBlog.class,new DynamoDBScanExpression());
        return allBlogs;
    }
/*
    Bl partnerDB;

    @Inject
    public BlogService(PartnerDB partnerDB) {
        this.partnerDB = partnerDB;
    }

    public Partner createItem(PartnerRequest partnerRequest) throws TDMInvalidRequestException, TDMCloudServiceException {
        Partner partner = Partner.builder()
                .partnerName(partnerRequest.getPartnerName())
                .partnerType(partnerRequest.getPartnerType())
                .logicalName(partnerRequest.getLogicalName())
                .folderPrefix(Arrays.stream(partnerRequest.getFolderPrefix()).collect(Collectors.toSet()))
                .serviceEmail(partnerRequest.getServiceEmail())
                .originRepo(partnerRequest.getOriginRepo())
                .regionalPreference(partnerRequest.getRegionalPreference())
                .manifestCapable(partnerRequest.getManifestCapable())
                .status(partnerRequest.getStatus())
                .createdOn(OffsetDateTime.now())
                .lastUpdated(OffsetDateTime.now())
                .userTouch(partnerRequest.getUserTouch())
                .build();
        Index index = partnerDB.getGetPartnerLogicalName();
        QuerySpec spec = partnerDB.getSpec(partnerRequest);
        if (partnerDB.printIndexItems(index, spec).isEmpty()) {
            try {
                partnerDB.createNewSecret(partnerRequest);
                partner = partnerDB.savePartner(partner);
                partnerDB.getClientCredentials(partner.getPartnerName(), partner);
                return partner;
            } catch (Exception tdmCex) {
                LOGGER.info(tdmCex);
                throw new TDMCloudServiceException("Unable to process the request. Error on cloud services.");
            }
        }else{
            throw new TDMInvalidRequestException("Bad Method POST: User PUT to update existing partners");
        }
      }

    public List<Partner> getPartner(String partnerName, String logicalName){
        List<Partner> retrievedPartners;
        if((partnerName == null || partnerName.length() == 0) && ((logicalName == null || logicalName.length() == 0))){
            retrievedPartners = partnerDB.getAllPartners();
        }else{
            retrievedPartners = partnerDB.loadPartner(partnerName,logicalName);
        }
        retrievedPartners.forEach(partner -> {
            try {
                partnerDB.getClientCredentials(partner.getPartnerName(), partner);
            } catch (TDMCloudServiceException e) {
                e.printStackTrace();
            }
        });
        return retrievedPartners;
    }*/


}



