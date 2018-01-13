package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue
    Long id;
    String vehicleRegisterNumber;
    Date vehicleFirstRegistrationDate;
    String vehicleUserName;
    String vehicleUserPesel;
    String vehicleUserAddress;
    String vehicleOwnerName;
    String vehicleOwnerPesel;
    String vehicleOwnerAddress;
    String vehicleBrand;
    String vehicleType;
    String vehicleModel;
    String vehicleIdentificationNumber;
    String vehicleMaxTotalMass;
    String vehiclePermissibleMass;
    String vehiclePermissibleMassGroup;
    String vehicleMassOwn;
    Date vehicleRegisterExpiryDate;
    Date vehicleRegisterSetUpDate;
    String vehicleCategory;
    String vehicleApprovalNumber;
    Integer vehicleNumberOfAxles;
    String vehicleTruckTrailerTotalMassWithBreaks;
    String vehicleTruckTrailerTotalMassWithoutBreaks;
    Integer vehicleEngineCapacity;
    String vehicleEngineMaxNetPower;
    String vehicleFuelType;
    String vehiclePowerToMass;
    Integer vehicleSeats;
    Integer vehicleStandingPlaces;

    public Vehicle() {
        super();
    }

    public Vehicle(Integer vehicleSeats, String vehiclePowerToMass, String vehicleFuelType, String vehicleEngineMaxNetPower, Integer vehicleEngineCapacity, String vehicleTruckTrailerTotalMassWithoutBreaks, String vehicleTruckTrailerTotalMassWithBreaks, Integer vehicleNumberOfAxles, String vehicleApprovalNumber, String vehicleCategory, Date vehicleRegisterSetUpDate, Date vehicleRegisterExpiryDate, String vehicleMassOwn, String vehiclePermissibleMassGroup, String vehiclePermissibleMass, String vehicleMaxTotalMass, String vehicleIdentificationNumber, String vehicleModel, String vehicleType, String vehicleBrand, String vehicleOwnerAddress, String vehicleOwnerPesel, String vehicleOwnerName, String vehicleUserAddress, String vehicleUserPesel, String vehicleUserName, Date vehicleFirstRegistrationDate, String vehicleRegisterNumber) {
        super();
        this.id = id;
        this.vehicleRegisterNumber = vehicleRegisterNumber;
        this.vehicleFirstRegistrationDate = vehicleFirstRegistrationDate;
        this.vehicleUserName = vehicleUserName;
        this.vehicleUserPesel = vehicleUserPesel;
        this.vehicleUserAddress = vehicleUserAddress;
        this.vehicleOwnerName = vehicleOwnerName;
        this.vehicleOwnerPesel = vehicleOwnerPesel;
        this.vehicleOwnerAddress = vehicleOwnerAddress;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.vehicleMaxTotalMass = vehicleMaxTotalMass;
        this.vehiclePermissibleMass = vehiclePermissibleMass;
        this.vehiclePermissibleMassGroup = vehiclePermissibleMassGroup;
        this.vehicleMassOwn = vehicleMassOwn;
        this.vehicleRegisterExpiryDate = vehicleRegisterExpiryDate;
        this.vehicleRegisterSetUpDate = vehicleRegisterSetUpDate;
        this.vehicleCategory = vehicleCategory;
        this.vehicleApprovalNumber = vehicleApprovalNumber;
        this.vehicleNumberOfAxles = vehicleNumberOfAxles;
        this.vehicleTruckTrailerTotalMassWithBreaks = vehicleTruckTrailerTotalMassWithBreaks;
        this.vehicleTruckTrailerTotalMassWithoutBreaks = vehicleTruckTrailerTotalMassWithoutBreaks;
        this.vehicleEngineCapacity = vehicleEngineCapacity;
        this.vehicleEngineMaxNetPower = vehicleEngineMaxNetPower;
        this.vehicleFuelType = vehicleFuelType;
        this.vehiclePowerToMass = vehiclePowerToMass;
        this.vehicleSeats = vehicleSeats;
        this.vehicleStandingPlaces = vehicleStandingPlaces;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleRegisterNumber() {
        return vehicleRegisterNumber;
    }

    public void setVehicleRegisterNumber(String vehicleRegisterNumber) {
        this.vehicleRegisterNumber = vehicleRegisterNumber;
    }

    public Date getVehicleFirstRegistrationDate() {
        return vehicleFirstRegistrationDate;
    }

    public void setVehicleFirstRegistrationDate(Date vehicleFirstRegistrationDate) {
        this.vehicleFirstRegistrationDate = vehicleFirstRegistrationDate;
    }

    public String getVehicleUserName() {
        return vehicleUserName;
    }

    public void setVehicleUserName(String vehicleUserName) {
        this.vehicleUserName = vehicleUserName;
    }

    public String getVehicleUserPesel() {
        return vehicleUserPesel;
    }

    public void setVehicleUserPesel(String vehicleUserPesel) {
        this.vehicleUserPesel = vehicleUserPesel;
    }

    public String getVehicleUserAddress() {
        return vehicleUserAddress;
    }

    public void setVehicleUserAddress(String vehicleUserAddress) {
        this.vehicleUserAddress = vehicleUserAddress;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public String getVehicleOwnerPesel() {
        return vehicleOwnerPesel;
    }

    public void setVehicleOwnerPesel(String vehicleOwnerPesel) {
        this.vehicleOwnerPesel = vehicleOwnerPesel;
    }

    public String getVehicleOwnerAddress() {
        return vehicleOwnerAddress;
    }

    public void setVehicleOwnerAddress(String vehicleOwnerAddress) {
        this.vehicleOwnerAddress = vehicleOwnerAddress;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String getVehicleMaxTotalMass() {
        return vehicleMaxTotalMass;
    }

    public void setVehicleMaxTotalMass(String vehicleMaxTotalMass) {
        this.vehicleMaxTotalMass = vehicleMaxTotalMass;
    }

    public String getVehiclePermissibleMass() {
        return vehiclePermissibleMass;
    }

    public void setVehiclePermissibleMass(String vehiclePermissibleMass) {
        this.vehiclePermissibleMass = vehiclePermissibleMass;
    }

    public String getVehiclePermissibleMassGroup() {
        return vehiclePermissibleMassGroup;
    }

    public void setVehiclePermissibleMassGroup(String vehiclePermissibleMassGroup) {
        this.vehiclePermissibleMassGroup = vehiclePermissibleMassGroup;
    }

    public String getVehicleMassOwn() {
        return vehicleMassOwn;
    }

    public void setVehicleMassOwn(String vehicleMassOwn) {
        this.vehicleMassOwn = vehicleMassOwn;
    }

    public Date getVehicleRegisterExpiryDate() {
        return vehicleRegisterExpiryDate;
    }

    public void setVehicleRegisterExpiryDate(Date vehicleRegisterExpiryDate) {
        this.vehicleRegisterExpiryDate = vehicleRegisterExpiryDate;
    }

    public Date getVehicleRegisterSetUpDate() {
        return vehicleRegisterSetUpDate;
    }

    public void setVehicleRegisterSetUpDate(Date vehicleRegisterSetUpDate) {
        this.vehicleRegisterSetUpDate = vehicleRegisterSetUpDate;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleApprovalNumber() {
        return vehicleApprovalNumber;
    }

    public void setVehicleApprovalNumber(String vehicleApprovalNumber) {
        this.vehicleApprovalNumber = vehicleApprovalNumber;
    }

    public Integer getVehicleNumberOfAxles() {
        return vehicleNumberOfAxles;
    }

    public void setVehicleNumberOfAxles(Integer vehicleNumberOfAxles) {
        this.vehicleNumberOfAxles = vehicleNumberOfAxles;
    }

    public String getVehicleTruckTrailerTotalMassWithBreaks() {
        return vehicleTruckTrailerTotalMassWithBreaks;
    }

    public void setVehicleTruckTrailerTotalMassWithBreaks(String vehicleTruckTrailerTotalMassWithBreaks) {
        this.vehicleTruckTrailerTotalMassWithBreaks = vehicleTruckTrailerTotalMassWithBreaks;
    }

    public String getVehicleTruckTrailerTotalMassWithoutBreaks() {
        return vehicleTruckTrailerTotalMassWithoutBreaks;
    }

    public void setVehicleTruckTrailerTotalMassWithoutBreaks(String vehicleTruckTrailerTotalMassWithoutBreaks) {
        this.vehicleTruckTrailerTotalMassWithoutBreaks = vehicleTruckTrailerTotalMassWithoutBreaks;
    }

    public Integer getVehicleEngineCapacity() {
        return vehicleEngineCapacity;
    }

    public void setVehicleEngineCapacity(Integer vehicleEngineCapacity) {
        this.vehicleEngineCapacity = vehicleEngineCapacity;
    }

    public String getVehicleEngineMaxNetPower() {
        return vehicleEngineMaxNetPower;
    }

    public void setVehicleEngineMaxNetPower(String vehicleEngineMaxNetPower) {
        this.vehicleEngineMaxNetPower = vehicleEngineMaxNetPower;
    }

    public String getVehicleFuelType() {
        return vehicleFuelType;
    }

    public void setVehicleFuelType(String vehicleFuelType) {
        this.vehicleFuelType = vehicleFuelType;
    }

    public String getVehiclePowerToMass() {
        return vehiclePowerToMass;
    }

    public void setVehiclePowerToMass(String vehiclePowerToMass) {
        this.vehiclePowerToMass = vehiclePowerToMass;
    }

    public Integer getVehicleSeats() {
        return vehicleSeats;
    }

    public void setVehicleSeats(Integer vehicleSeats) {
        this.vehicleSeats = vehicleSeats;
    }

    public Integer getVehicleStandingPlaces() {
        return vehicleStandingPlaces;
    }

    public void setVehicleStandingPlaces(Integer vehicleStandingPlaces) {
        this.vehicleStandingPlaces = vehicleStandingPlaces;
    }
}
