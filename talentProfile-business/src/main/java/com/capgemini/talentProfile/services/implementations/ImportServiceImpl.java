package com.capgemini.talentProfile.services.implementations;

import com.capgemini.talentProfile.GeneralConstants;
import com.capgemini.talentProfile.persistant.*;
import com.capgemini.talentProfile.repository.*;
import com.capgemini.talentProfile.services.implementations.exceptions.ValidationException;
import com.capgemini.talentProfile.services.interfaces.ImportServiceInt;
import com.capgemini.talentProfile.utils.DateUtils;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.capgemini.talentProfile.utils.DateUtils.stringToDate;

@Service
@Transactional
public class ImportServiceImpl implements ImportServiceInt {

    private static final Logger LOGGER = Logger.getLogger(ImportServiceImpl.class);

    @Autowired
    SesameRepo sesameRepository;

    @Autowired
    InfoRetainRepo infoRetainRepo;

    @Autowired
    InfoMyPathEppRepo infoMyPathEppRepo;

    @Autowired
    InfoMyPathHistoRepo infoMyPathHistoRepo;

    @Autowired
    CollabCmRepo collabCmRepo;

    @Autowired
    InfoMyPathCedRepo infoMyPathRepo;

    @Autowired
    UserRoleRepo userRoleRepo;

    /**
     * @param row
     * @return
     */
    private List<String> getValues(HSSFRow row, int nbColumns) {
        LOGGER.info("+ Start getValues");

        List<String> values = new ArrayList<>();
        for (int i = 0; i < nbColumns; i++) {
            HSSFCell cell = row.getCell(i);
            if (cell == null) {
                values.add(null);
            } else {
                if (CellType.NUMERIC == cell.getCellTypeEnum()) {
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        values.add(DateUtils.dateToString(cell.getDateCellValue(), GeneralConstants.DATE_FORMAT));
                    } else {
                        values.add(Integer.toString((int) cell.getNumericCellValue()));
                    }
                } else {
                    String cellValue = cell.getStringCellValue();
                    Date date = stringToDate(cellValue);
                    if (date != null) {
                        values.add(DateUtils.dateToString(date, GeneralConstants.DATE_FORMAT));
                    } else {
                        values.add(cellValue);
                    }
                }
            }
        }
        LOGGER.info("- End getValues");

        return values;
    }

    /**
     * @param inputStream
     * @param sheetIndex
     * @return
     */
    private List<List<String>> getAllValues(InputStream inputStream, int sheetIndex) {
        LOGGER.info("+ Start getAllValues");

        List<List<String>> listOfValues = new ArrayList<>();

        try {

            POIFSFileSystem fs = new POIFSFileSystem(inputStream);

            HSSFSheet sheet;
            try (HSSFWorkbook workbook = new HSSFWorkbook(fs)) {
                sheet = workbook.getSheetAt(sheetIndex);
            }

            Iterator<Row> rows = sheet.rowIterator();
            HSSFRow row = (HSSFRow) rows.next();
            int nbColumns = row.getLastCellNum();

            while (rows.hasNext()) {

                row = (HSSFRow) rows.next();
                if (isRowEmpty(row)) {
                    break;
                }
                List<String> values = getValues(row, nbColumns);
                listOfValues.add(values);
            }
            inputStream.close();
        } catch (IOException e) {

        }
        LOGGER.info("- End getAllValues");

        return listOfValues;

    }

    /**
     * @param input
     */
    @Override
    public void importFromSesame(InputStream input) {
        LOGGER.info("+ Start importFromSesame");

        List<List<String>> listOfValues = getAllValues(input, 0);
        for (List<String> values : listOfValues) {

            Sesame infosSesame = new Sesame(values.get(0), values.get(1), (long) Integer.parseInt(values.get(2)),
                    values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8),
                    values.get(9), values.get(10), values.get(11), values.get(12), values.get(13), values.get(14),
                    values.get(15), values.get(16), values.get(17), values.get(18), values.get(19), values.get(20),
                    values.get(21), values.get(22), values.get(23), values.get(24), values.get(25), values.get(26),
                    values.get(27), values.get(28), values.get(29), values.get(30), values.get(31), values.get(32),
                    values.get(33), values.get(34), values.get(35), values.get(36), values.get(37), values.get(38),
                    values.get(39), values.get(40), values.get(41), values.get(42), values.get(43), values.get(44),
                    values.get(45), values.get(46), values.get(47), values.get(48), values.get(49), values.get(50),
                    values.get(51), values.get(52), values.get(53), values.get(54), values.get(55), values.get(56),
                    values.get(57), values.get(58), values.get(59), values.get(60), values.get(61), values.get(62),
                    values.get(63), values.get(64), values.get(65), values.get(66), values.get(67), values.get(68),
                    values.get(69), values.get(70), values.get(71), values.get(72), values.get(73), values.get(74),
                    values.get(75), values.get(76), values.get(77), values.get(78), values.get(79));

            sesameRepository.save(infosSesame);
        }

        LOGGER.info("- End importFromSesame");

    }

    /**
     * @param input
     */
    @Override
    public void importFromInfoRetain(final InputStream input) {
        LOGGER.info("+ Start importFromInfoRetain");

        List<List<String>> listOfValues = getAllValues(input, 0);
        for (List<String> values : listOfValues) {
            InfoRetain infoRetain = new InfoRetain(values.get(0), (long) Integer.parseInt(values.get(1)), values.get(2),
                    values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8),
                    values.get(9), values.get(10));
            infoRetainRepo.save(infoRetain);
        }

        LOGGER.info("- End importFromInfoRetain");
    }

    /**
     * @param input
     */
    @Override
    public void importFromMyPathHisto(InputStream input) {
        LOGGER.info("+ Start importFromMyPathHisto");

        List<List<String>> listOfValues = getAllValues(input, 0);
        long lineNo = 0;
        for (List<String> values : listOfValues) {
            lineNo++;
            InfoMyPathHisto infoHisto = new InfoMyPathHisto(lineNo, values.get(0), values.get(1),
                    (long) Integer.parseInt(values.get(2)), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8),
                    values.get(9), values.get(10), values.get(11), values.get(12), values.get(13), values.get(14),
                    values.get(15), values.get(16), values.get(17), values.get(18), values.get(19), values.get(20),
                    values.get(21), values.get(22), values.get(23), values.get(24), values.get(25), values.get(26),
                    values.get(27), values.get(28), values.get(29), values.get(30), values.get(31), values.get(32),
                    values.get(33), values.get(34), values.get(35), values.get(36), values.get(37), values.get(38),
                    values.get(39), values.get(40), values.get(41));
            infoMyPathHistoRepo.save(infoHisto);
        }

        LOGGER.info("- End importFromMyPathHisto");

    }

    /**
     * @param input
     */
    @Override
    public void importFromMyPathEpp(InputStream input) {
        LOGGER.info("+ Start importFromMyPathEpp");

        List<List<String>> listOfValues = getAllValues(input, 1);
        long lineNo = 0;
        for (List<String> values : listOfValues) {
            lineNo++;
            InfoMyPathEpp infoEPP = new InfoMyPathEpp(lineNo, (long) Integer.parseInt(values.get(0)), values.get(1),
                    values.get(2), values.get(3), values.get(5), values.get(6), values.get(7), values.get(8),
                    values.get(9), values.get(10), values.get(11), values.get(12), values.get(13), values.get(14),
                    values.get(15), values.get(16), values.get(17), values.get(18), values.get(19), values.get(20),
                    values.get(21), values.get(22), values.get(23), values.get(24), values.get(25), values.get(26),
                    values.get(27), values.get(28), values.get(29), values.get(30), values.get(31), values.get(32),
                    values.get(33), values.get(34), values.get(35), values.get(36), values.get(37), values.get(38),
                    values.get(39), values.get(40), values.get(41), values.get(42), values.get(43), values.get(44),
                    values.get(45), values.get(46), values.get(47), values.get(48), values.get(49), values.get(50),
                    values.get(51), values.get(52), values.get(52), values.get(54), values.get(55), values.get(56),
                    values.get(57), values.get(58), values.get(59), values.get(60), values.get(61), values.get(62),
                    values.get(63), values.get(64), values.get(65), values.get(66), values.get(67), values.get(68),
                    values.get(69));

            infoMyPathEppRepo.save(infoEPP);
        }

        LOGGER.info("- End importFromMyPathEpp");

    }

    /**
     * @param input
     */
    @Override
    public void importFromMyPathCed(InputStream input) {
        LOGGER.info("+ Start importFromMyPathCed");

        List<List<String>> listOfValues = getAllValues(input, 0);
        long lineNo = 0;
        for (List<String> values : listOfValues) {
            lineNo++;
            InfoMyPathCed ced = new InfoMyPathCed(lineNo, (long) Integer.parseInt(values.get(0)), values.get(1),
                    values.get(2), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8),
                    values.get(9), values.get(10), values.get(11), values.get(12), values.get(13), values.get(14),
                    values.get(15), values.get(16), values.get(17), values.get(18), values.get(19), values.get(20),
                    values.get(21), values.get(22), values.get(23), values.get(24), values.get(25), values.get(26),
                    values.get(27), values.get(28), values.get(29), values.get(30), values.get(31), values.get(32),
                    values.get(33), values.get(34), values.get(35), values.get(36), values.get(37), values.get(38),
                    values.get(39), values.get(40), values.get(41), values.get(42));
            infoMyPathRepo.save(ced);
        }

        LOGGER.info("- End importFromMyPathCed");

    }

    /**
     * @param input
     */
    @Override
    public void importFromCollabCm(InputStream input) {
        LOGGER.info("+ Start importFromCollabCm");

        Map<Long, List<String>> map = new HashMap<>();
        List<List<String>> listOfValues = getAllValues(input, 0);

        for (List<String> values : listOfValues) {
            final long ggIdCm = (long) Integer.parseInt(values.get(5));
            final CollabCm collabCm = new CollabCm((long) Integer.parseInt(values.get(0)), values.get(1),
                    values.get(2), values.get(3), values.get(4), ggIdCm, values.get(6), values.get(7));

            List<String> cmCollabInfos = new ArrayList<>();
            cmCollabInfos.add(values.get(6));
            cmCollabInfos.add(values.get(7));

            map.put(ggIdCm, cmCollabInfos);

            collabCmRepo.save(collabCm);
        }
        map.forEach((k, v) -> {
            persistCmUserRole(k, v);
        });

        LOGGER.info("- End importFromCollabCm");

    }

    private void persistCmUserRole(Long ggIdCm, List<String> cmInfos) {
        LOGGER.info("+ Start persistCmUserRole");

        final UserRole userRole = UserRole.builder().ggid(ggIdCm).//
                role(GeneralConstants.ROLE_CM).//
                lastName(cmInfos.get(0)).//
                firstName(cmInfos.get(1)).build();
        userRoleRepo.save(userRole);

        LOGGER.info("- End persistCmUserRole");

    }

    @Override
    public void importFromUserRole(InputStream inputStream) {
        LOGGER.info("+ Start importFromUserRole");

        List<List<String>> listOfValues = getAllValues(inputStream, 0);
        for (List<String> values : listOfValues) {
            if (!StringUtils.isNumeric(values.get(0))) {
                throw new ValidationException(ValidationException.ValidationExceptionError.NOT_VALID_GGID,
                        ValidationException.ValidationExceptionError.NOT_VALID_GGID.getMessage());
            }

            final UserRole userRole = UserRole.builder().ggid((long) Integer.parseInt(values.get(0))).//
                    lastName(values.get(1)).//
                    firstName(values.get(2)).//
                    startDate(values.get(3)).//
                    endDate(values.get(4)).//
                    etablissement(values.get(5)).//
                    uniteOrganisat(values.get(6)).//
                    pusap(values.get(7)).
                    role(values.get(8)).//
                    password(values.get(9)).
                    build();
            userRoleRepo.save(userRole);
        }

        LOGGER.info("- End importFromUserRole");

    }

    /**
     *
     * @param row
     * @return
     */
    private boolean isRowEmpty(Row row) {
        if (row == null) {
            return true;
        }
        if (row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && !CellType.BLANK.equals(cell.getCellTypeEnum()) && StringUtils.isNotBlank(cell.toString())) {
                return false;
            }
        }
        return true;
    }
}