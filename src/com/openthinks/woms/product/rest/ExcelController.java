package com.openthinks.woms.product.rest;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.account.Account;
import com.openthinks.woms.account.service.AccountService;
import com.openthinks.woms.order.OrderForm;
import com.openthinks.woms.order.service.OrderService;
import com.openthinks.woms.rest.GenericRestfulController;

/**
 * 导入导出excel控制器
 * 
 * Restful 请求方式
 * 
 * @author Zhang Wenlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "excel" }) })
public class ExcelController extends GenericRestfulController {

	private static final long serialVersionUID = 3697796440732941460L;

	private static final Log log = LogFactory.getLog(ExcelController.class);

	private String id;

	@Autowired
	private AccountService accountService;

	@Autowired
	private OrderService orderService;

	@Override
	public HttpHeaders create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String destroy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	public InputStream exportExcel() throws Exception {
		OutputStream os = null;
		WritableWorkbook wwb = null;
		try {

			// 新建一张表
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/vnd.ms-excel");
			response.addHeader(
					"Content-Disposition",
					"attachment;   filename=\""
							+ new String("nikkis客户订货详单".getBytes("gb2312"),
									"ISO8859-1") + ".xls" + "\"");
			os = response.getOutputStream();
			wwb = Workbook.createWorkbook(os);

			Collection<Account> accounts = this.accountService.find();
			for (Account account : accounts) {
				WritableSheet wsheet = wwb.createSheet(account.getId() + "订单",
						0);

				// 居中
				WritableCellFormat cellFormat = new WritableCellFormat();
				cellFormat.setAlignment(jxl.format.Alignment.CENTRE);

				Label label = new Label(0, 0, "条码");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(1, 0, "品牌");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(2, 0, "助记码");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(3, 0, "款名");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(4, 0, "款号");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(5, 0, "波段");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(6, 0, "款型");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(7, 0, "系列");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(8, 0, "尺码");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(9, 0, "颜色");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(10, 0, "订货价");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(11, 0, "件数");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				label = new Label(12, 0, "总金额");
				label.setCellFormat(cellFormat);
				wsheet.addCell(label);

				wsheet.setColumnView(0, 20);
				wsheet.setColumnView(1, 15);
				wsheet.setColumnView(2, 10);
				wsheet.setColumnView(3, 15);
				wsheet.setColumnView(4, 10);
				wsheet.setColumnView(5, 10);
				wsheet.setColumnView(6, 10);
				wsheet.setColumnView(7, 10);
				wsheet.setColumnView(8, 10);
				wsheet.setColumnView(9, 10);
				wsheet.setColumnView(10, 10);
				wsheet.setColumnView(11, 10);
				wsheet.setColumnView(12, 15);

				List<OrderForm> orders = this.orderService.read(account
						.getUserId());
				if (CollectionUtils.isNotEmpty(orders)) {
					for (int i = 1; i < orders.size() + 1; i++) {
						OrderForm order = orders.get(i - 1);

						label = new Label(0, i, order.getProduct().getModel()
								+ order.getColor().getCode()
								+ order.getSize().getCode());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(1, i, order.getProduct().getBrand()
								.getText());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(2, i, order.getProduct()
								.getBrevityCode());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(3, i, order.getProduct().getName());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(4, i, order.getProduct().getModel());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(5, i, order.getProduct().getSeason()
								.getName());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(6, i, order.getProduct().getStyle()
								.getName());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(7, i, order.getProduct().getSeries()
								.getName());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(8, i, order.getSize().getName());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(9, i, order.getColor().getName());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(10, i, Double.valueOf(
								order.getProduct().getOrderingPrice())
								.toString());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						label = new Label(11, i, Integer.valueOf(
								order.getQuantity()).toString());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);

						BigDecimal orderingPrice = new BigDecimal(order
								.getProduct().getOrderingPrice());
						BigDecimal quantity = new BigDecimal(
								order.getQuantity());

						BigDecimal totalPrice = orderingPrice
								.multiply(quantity);

						label = new Label(12, i, totalPrice.setScale(2,
								RoundingMode.HALF_UP).toString());
						label.setCellFormat(cellFormat);
						wsheet.addCell(label);
					}
				}
			}
			wwb.write();
		} catch (Exception e) {
			log.error("exportExcel()  error...", e);
		} finally {
			if (wwb != null) {
				try {
					wwb.close();
				} catch (Exception e2) {
					log.error("wwb close() error....", e2);
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (Exception e2) {
					log.error("os close() error....", e2);
				}
			}

		}
		return null;
	}

	public void setId(String id) {
		this.id = id;
	}

}
